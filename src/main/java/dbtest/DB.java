package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

public class DB {

	private Connection conn;

	public boolean connect(String url, String driver, String user, String password) throws SQLException {
		DbUtils.loadDriver(driver);
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("Using Database " + conn.getMetaData().getDatabaseProductName() + " "
				+ conn.getMetaData().getDatabaseProductVersion());
		return conn.isValid(1);
	}

	public void close() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

}
