package Vjezbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRowStudents2 {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/students2";
	
	public static void main(String[] args) throws SQLException {
		String query1 = "SELECT * FROM info WHERE id = 2";
		String query2 = "UPDATE info SET name = 'Jasmin' WHERE id = 2";
		ResultSet rs = null;
		
		try(Connection connection = DriverManager.getConnection(CONN_DB, USER_NAME, PASSWORD)){
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(query1);
			print(rs);
			statement.executeUpdate(query2);
			rs = statement.executeQuery(query1);
			print(rs);
			rs.close();
		}
	}

	private static void print(ResultSet rs) throws SQLException {
		while(rs.next()){
			System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", "
					+ "lastname: " + rs.getString("lastname") + ", age: " + rs.getDate("age") + ", "
					+ "email: " + rs.getString("email"));
		}
		rs.close();
	}
}
