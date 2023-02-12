package model;

import java.sql.Connection;
import java.sql.SQLException;

import Database.DBConnectionPool;

public class TestProdotto {
	private Connection db;
	public void setUp() throws SQLException {
		try {
			db=DBConnectionPool.getConnection();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
