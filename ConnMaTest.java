package Vjezbe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnMaTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = ConnManager.getInstance().getConnection();
		
		String sqlQuery = "SELECT * FROM info";
		
		ResultSet rs = null;
		
		try {
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(sqlQuery);
			print(rs);
			ConnManager.getInstance().close();
		} catch (SQLException e){
			e.printStackTrace();
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
