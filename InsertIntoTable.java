package Vjezbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertIntoTable {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/students2";
	
	public static void main(String[] args) throws SQLException {

		String sqlQuery = "INSERT INTO info VALUES (null, 'Bob', 'Dole', '1999-02-03', 'bobdole@hotmail.com'), "
				+ "(null, 'joe', 'bigg', '2000-04-05', 'joebigg@gmail.com')";
		
		try (Connection connection = DriverManager.getConnection(CONN_DB, USER_NAME, PASSWORD)){
			Statement statement = connection.createStatement();
			statement.executeUpdate(sqlQuery);
			System.out.println("Table " + getTableName(sqlQuery) + " was updated with new data");
		}
	}

	private static String getTableName(String sqlQuery) {
		String[] stringList = sqlQuery.split(" ");
		return stringList[2];
	}
}
