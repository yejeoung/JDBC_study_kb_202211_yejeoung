package main.java.com.study.jabc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

import main.java.com.study.jabc.util.DBConnection;

public class JdbcSelect1 {

	public static void main(String[] args) {
//		System.out.println(Driver.class.getName());
//		//경로를 찾아서 경로 이름 출력
		
		Connection connection = DBConnection.getInstance().getConnection();
		
//		System.out.println(connection);
//		//경로를 찾아서 경로 이름 출력
		
		
		/*----------------------12/15---------------------*/
		
		String sql = "select * from score_mst";
		//쿼리문 작성
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("id\t name\t\t score");
			
			while(rs.next()) {
				System.out.println("id: " + rs.getInt(1) 
				+ "\t name: " + rs.getString(2) 
				+ "\t score: " + rs.getInt(3));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
