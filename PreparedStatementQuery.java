package Vjezbe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementQuery {

	private static final String USER_NAME = "root";
	private static final String PASSWORD = "password";
	private static final String CONN_DB = "jdbc:mysql://localhost/students2";
	
	public static void main(String[] args) throws SQLException {
		String query = "SELECT * FROM info WHERE id = ?";
		ResultSet rs = null;
		
		System.out.println("Please enter id number of the studnet");
		
		Scanner input = new Scanner(System.in);
		int idNum = input.nextInt();
		input.close();
		
		try(Connection conn = DriverManager.getConnection(CONN_DB, USER_NAME, PASSWORD);
				PreparedStatement pstat = conn.prepareStatement(query);){
			pstat.setInt(1, idNum);
			rs = pstat.executeQuery();
			print(rs, idNum);
		}
	}

	private static void print(ResultSet rs, int idNum) throws SQLException {
		if(rs.next()){
			System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", "
					+ "lastname: " + rs.getString("lastname") + ", age: " + rs.getDate("age") + ", "
					+ "email: " + rs.getString("email"));
		}
		else
			System.out.println("No data for student with id number " + idNum);
		
		rs.close();
	}
}
