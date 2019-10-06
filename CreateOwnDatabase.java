package Vjezbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOwnDatabase {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/";
	
	public static void main(String[] args) {
		
		String sqlQuery = "CREATE DATABASE students";
		
		try (Connection connection = DriverManager.getConnection(CONN_DB, USER_NAME, PASSWORD)){
			Statement statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Database " + databaseName(sqlQuery) + " has been successfuly created");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			System.out.println("Final and complete");
		}
	}

	private static String databaseName(String sqlQuery) {
		String[] stringList = sqlQuery.split(" ");
		return stringList[stringList.length - 1];
	} 
}
