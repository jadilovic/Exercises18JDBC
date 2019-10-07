package Vjezbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOwnTable {
	
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/students2";

	public static void main(String[] args) {

		String sqlQuery = "CREATE TABLE info ("
				+ "id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, "
				+ "name VARCHAR(70), "
				+ "lastName VARCHAR(70), "
				+ "age DATE, "
				+ "email VARCHAR(70)"
				+ ");";
		
		try(Connection connection = DriverManager.getConnection(CONN_DB, USER_NAME, PASSWORD)){
			Statement statement = connection.createStatement();
			System.out.println(statement.executeUpdate(sqlQuery));
			System.out.println("Table was created");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
