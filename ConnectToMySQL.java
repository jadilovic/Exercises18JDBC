package Vjezbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToMySQL {
	
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_STRING = "jdbc:mysql://localhost/students3";
	
	public static void main(String[] args) throws SQLException {

		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(CONN_STRING, USER_NAME, PASSWORD);
			System.out.println("Connection is successful");
			
		} catch (SQLException e){
			System.err.println(e);
		} finally {
			if(connection != null)
				connection.close();
		}
	}

}
