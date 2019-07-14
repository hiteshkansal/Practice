/**
 * 
 */
package com.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Hitesh
 *
 */
public interface ConnectionPool {

	Connection getConnection() throws SQLException;
	void releaseConnection(Connection con) throws SQLException;
}
