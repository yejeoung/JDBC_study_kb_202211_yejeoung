package main.java.com.study.jabc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jabc.util.DBConnection;

public class JdbcInsert1 {
	public static void main(String[] args) {
		/* user_mst 데이터에 Scanner로 받은 데이터를 추가하기 */
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("등록할 아이디 입력: ");
		String username = scanner.nextLine();

		Connection con = DBConnection.getInstance().getConnection();
		String sql = "insert into user_mst values(0, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			// 첫 번째 물음표에 username을 넣어주어라.
			int successCount = pstmt.executeUpdate();
			System.out.println("데이터 " + successCount + "건 등록완료!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
// 아이디를 등록하고 workbeach에 들어가서 확인해보면 데이터가 추가 되어있음
