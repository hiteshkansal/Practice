package com.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomConnectionPoolImpl implements Runnable, CustomConnectionPool {

	private String driver, url, pwd, username;
	private int maxConnectons;
	private List<Connection> availableConn, busyConn;

	public CustomConnectionPoolImpl(String driver, String url, String username, String pwd, int initConnection,
			int maxConnection) throws SQLException {
		if (driver == null)
			throw new IllegalArgumentException("Driver is null");
		if (url == null)
			throw new IllegalArgumentException("url is null");
		if (username == null || pwd == null)
			throw new IllegalArgumentException("user or pwd is null");
		if (maxConnection <= 0)
			throw new IllegalArgumentException("max connections > 0");
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.pwd = pwd;
		this.maxConnectons = maxConnection;

		if (initConnection > maxConnection)
			initConnection = maxConnection;
		availableConn = Collections.synchronizedList(new ArrayList<>(initConnection));
		busyConn = Collections.synchronizedList(new ArrayList<>());
		for (int i = 0; i < initConnection; i++) {
			availableConn.add(makeNewConnection());
		}
	}

	@Override
	public synchronized Connection getConnection() throws SQLException {
		if (!availableConn.isEmpty()) {
			int lastindex = availableConn.size() - 1;
			Connection exist = availableConn.get(lastindex);
			availableConn.remove(lastindex);
			if (exist.isClosed()) {
				notifyAll();
				return getConnection();
			} else {
				busyConn.add(exist);
				return exist;
			}
		} else {
			if (getNumberOfAvailableConnections() + getNumberOfBusyConnections() < maxConnectons) {
				makeBackgroundConnection();
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return getConnection();
	}

	private void makeBackgroundConnection() {

		Thread connectionthread = new Thread();
		connectionthread.start();
	}

	@Override
	public void run() {

		try {
			Connection newCon = makeNewConnection();
			synchronized (this) {
				availableConn.add(newCon);
				notifyAll();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Connection makeNewConnection() throws SQLException {

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, pwd);
			return con;
		} catch (ClassNotFoundException e) {
			throw new SQLException("can't find class for driver..");
		}
	}

	@Override
	public void releaseConnection(Connection con) throws SQLException {

		busyConn.remove(con);
		availableConn.add(con);
		notifyAll();
	}

	@Override
	public int getNumberOfAvailableConnections() {
		return availableConn.size();
	}

	@Override
	public int getNumberOfBusyConnections() {
		return busyConn.size();
	}

	@Override
	public void closeAllConnections() {

		closeConnections(availableConn);
		availableConn = Collections.synchronizedList(new ArrayList<Connection>());
		closeConnections(busyConn);
		busyConn = Collections.synchronizedList(new ArrayList<Connection>());
	}

	private void closeConnections(List<Connection> conn) {

		try {
			for (Connection c : conn) {
				if (!c.isClosed())
					c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
