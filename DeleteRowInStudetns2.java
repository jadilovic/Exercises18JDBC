package Vjezbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRowInStudetns2 {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/students2";
	
	public static void main(String[] args) throws SQLException {
		
		String query = "DELETE FROM info WHERE id = 4";
		String query2 = "SELECT * FROM info";
		ResultSet rs = null;
		
		try(Connection conn = DriverManager.getConnection(CONN_DB, USER_NAME, PASSWORD)){
			Statement sta = conn.createStatement();
			rs = sta.executeQuery(query2);
			printRs(rs);
			sta.executeUpdate(query);
			rs = sta.executeQuery(query2);
			printRs(rs);
		}
	}

	private static void printRs(ResultSet rs) throws SQLException {
		while(rs.next()){
			System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", "
					+ "lastname: " + rs.getString("lastname") + ", age: " + rs.getDate("age") + ", "
					+ "email: " + rs.getString("email"));
		}
		rs.close();
	}
}
