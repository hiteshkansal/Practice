/**
 * 
 */
package com.connectionpool;

/**
 * @author Hitesh
 *
 */
public interface CustomConnectionPool extends ConnectionPool{

	public int getNumberOfAvailableConnections();
	public int getNumberOfBusyConnections();
	public void closeAllConnections();
}
