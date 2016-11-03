/*
 * Connection.java     0.0.1 2013/04/04 
 * Copyright(C) 2013 db-iir RUC. All rights reserved. 
 */

package cn.edu.ruc.iir.jdbc43x;

import java.sql.*;

/**
 * This <code>Statement</code> implements the java.sql.Statement interface. It
 * opens an input stream from rdf3xembedded and pass the stream as a parameter
 * to the constructor of cn.edu.ruc.iir.ResultSet. So it does not load all the
 * data into memory and does not cause a OutOfMemory error.
 * 
 * @author Hank Bian (bianhaoqiong@gmail.com)
 * @version 0.0.1, 2013/04/04
 * @see java.sql.Statement
 */

// This work is licensed under the Creative Commons
// Attribution-Noncommercial-Share Alike 3.0 Unported License. To view a copy
// of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/
// or send a letter to Creative Commons, 171 Second Street, Suite 300,
// San Francisco, California, 94105, USA.

public final class Statement implements java.sql.Statement
{
	// The connection
	private Connection connection;

	// Constructor
	Statement(Connection connection)
	{
		this.connection = connection;
	}

	// Add to batch
	public void addBatch(String sql) throws SQLException
	{
		throw new SQLException();
	}

	// Cancel the statment
	public void cancel() throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Clear the batch
	public void clearBatch()
	{
	}

	// Clear all warnings
	public void clearWarnings()
	{
	}

	// Release resources
	public void close()
	{
		connection = null;
	}

	// Execute a statement
	public boolean execute(String sql) throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Execute a statment
	public boolean execute(String sql, int autoGeneratedKeys)
			throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Execute a statement
	public boolean execute(String sql, int[] columnIndexes) throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Execute a statement
	public boolean execute(String sql, String[] columnNames)
			throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Execute a batch
	public int[] executeBatch() throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Execute a query
	private java.sql.ResultSet executeQueryInternal(String query,
			FunctionCallback callback) throws SQLException
	{
		synchronized (connection)
		{
			// Send the query
			connection.assertOpen();
			connection.writeLine(query);

			// Check the answer
			String response = connection.readLine();
			if (!("ok".equals(response)))
				throw new SQLException(response);

			// Header
			String[] header = connection.readResultLine();

			return new ResultSet(header, connection, callback);
		}
	}

	// Execute a query
	public java.sql.ResultSet executeQuery(String query) throws SQLException
	{
		return executeQueryInternal(query, null);
	}

	// Execute a query
	public java.sql.ResultSet executeQueryWithFunctions(String query,
			FunctionCallback functions) throws SQLException
	{
		return executeQueryInternal(query, functions);
	}

	// Execute a statement
	public int executeUpdate(String sql) throws SQLException
	{
		executeQuery(sql);
		return 0;
	}

	// Execute a statement
	public int executeUpdate(String sql, int autoGeneratedKeys)
			throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Execute a statment
	public int executeUpdate(String sql, int[] columnIndexes)
			throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Execute a statement
	public int executeUpdate(String sql, String[] columnNames)
			throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Get the connection
	public java.sql.Connection getConnection()
	{
		return connection;
	}

	// Get the fetch direction
	public int getFetchDirection()
	{
		return ResultSet.FETCH_FORWARD;
	}

	// Get the fetch size
	public int getFetchSize()
	{
		return 0;
	}

	// Generated keys
	public ResultSet getGeneratedKeys() throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Maximum field size
	public int getMaxFieldSize()
	{
		return 0;
	}

	// Maximum number of rows
	public int getMaxRows()
	{
		return 0;
	}

	// Get more results
	public boolean getMoreResults()
	{
		return false;
	}

	// Get mmore result
	public boolean getMoreResults(int current)
	{
		return false;
	}

	// Query timeout
	public int getQueryTimeout()
	{
		return 0;
	}

	// Results
	public ResultSet getResultSet()
	{
		return null;
	}

	// Concurrency
	public int getResultSetConcurrency()
	{
		return ResultSet.CONCUR_READ_ONLY;
	}

	// Holdability
	public int getResultSetHoldability()
	{
		return ResultSet.CLOSE_CURSORS_AT_COMMIT;
	}

	// Scroll behavior
	public int getResultSetType()
	{
		return ResultSet.TYPE_FORWARD_ONLY;
	}

	// Update count
	public int getUpdateCount()
	{
		return 0;
	}

	// Warnings
	public SQLWarning getWarnings()
	{
		return null;
	}

	// Closed
	public boolean isClosed()
	{
		return connection == null;
	}

	// Poolable
	public boolean isPoolable()
	{
		return false;
	}

	// Cursor name
	public void setCursorName(String name) throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Escape processing
	public void setEscapeProcessing(boolean enable) throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Fetch direction
	public void setFetchDirection(int direction) throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Fetch size
	public void setFetchSize(int rows)
	{
	}

	// Maximum field size
	public void setMaxFieldSize(int max)
	{
	}

	// Maximum number of rows
	public void setMaxRows(int max)
	{
	}

	// Poolable?
	public void setPoolable(boolean poolable) throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Query timeout
	public void setQueryTimeout(int seconds) throws SQLException
	{
		throw new SQLFeatureNotSupportedException();
	}

	// Wrapper?
	public boolean isWrapperFor(Class<?> iface)
	{
		return false;
	}

	// Unwrap
	public <T> T unwrap(Class<T> iface) throws SQLException
	{
		throw new SQLException();
	}

	@Override
	public void closeOnCompletion() throws SQLException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCloseOnCompletion() throws SQLException
	{
		// TODO Auto-generated method stub
		return false;
	}
}
