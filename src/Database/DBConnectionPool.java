package Database;



import java.sql.*;
import java.util.*;

/*
	Routine standard di connessione al database previste da JDBC.
*/
public class DBConnectionPool {
	private static List<Connection> freeDbConnections;

	static {
		freeDbConnections = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	private static Connection createDBConnection() throws SQLException {
		Connection newConnection = null;

		String ip = "localhost";
		String port = "3306";

		String db = "azienda1";
		String username = "root";
		String password = "Formula12.";

		String params = "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&zeroDateTimeBehavior=CONVERT_TO_NULL&autoReconnect=true";

		newConnection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + db + params, username, password);
		newConnection.setAutoCommit(true);
		System.out.println("DBConnectionPool Connessione OK\n");
		return newConnection;
	}

	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;

		if (!freeDbConnections.isEmpty()) {
			connection = (Connection) freeDbConnections.get(0);
			DBConnectionPool.freeDbConnections.remove(0);

			try {
				if (connection.isClosed()) {
					connection = DBConnectionPool.getConnection();
					//connection = DBConnectionPool.createDBConnection();
				}
			} catch (SQLException e) {
				connection = DBConnectionPool.getConnection();
			}
		} else {
			connection = DBConnectionPool.createDBConnection();

		}

		return connection;
	}

	public static synchronized void releaseConnection(Connection connection) {
		DBConnectionPool.freeDbConnections.add(connection);
	}

}