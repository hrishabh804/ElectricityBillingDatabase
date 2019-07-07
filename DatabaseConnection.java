package hrishabh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

	private static final String username = "harish";
	private static final String password = "Hrish@123";
	private static Connection connection;

	synchronized public static void init() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DatabaseProject", username,
						password);
			} catch (SQLException e) {
				throw new RuntimeException("failed to execute statement", e);
			}
		}

	}

	public static void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("close connection");
		}
	}

	public static ResultSet execute(final String sql) {
		try {
			return connection.createStatement().executeQuery(sql);

		} catch (SQLException e) {
			throw new RuntimeException("failed to execute statement" + sql, e);
		}

	}
}
