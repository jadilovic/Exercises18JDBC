package Vjezbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetLoopinTable {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/students2";
	
	public static void main(String[] args) throws SQLException {
		String query = "SELECT * FROM info";
		ResultSet rs = null;
		try(Connection connection = DriverManager.getConnection(CONN_DB, USER_NAME, PASSWORD)){
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
			while(rs.next()){
				System.out.println("id: " + rs.getInt("id") + "\nname: " + rs.getString("name") + ""
						+ "\nlastname: " + rs.getString("lastname") + "\nage: " + rs.getDate("age") + ""
						+ "\nemail: " + rs.getString("email"));
			}
			rs.close();
		}
	}
}
