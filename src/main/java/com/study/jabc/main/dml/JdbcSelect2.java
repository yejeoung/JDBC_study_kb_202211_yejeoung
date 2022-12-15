package main.java.com.study.jabc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jabc.util.DBConnection;

public class JdbcSelect2 {
	public static void main(String[] args) {
		/* 데이터베이스의 borad_mst의 데이터를 가지고 와서 Java에서 출력해라. */

		/* 데이터베이스의 borad_mst의 데이터를 가지고 와서 Scanner를 받아 Java에서 출력해라. */

		Scanner scanner = new Scanner(System.in);
		System.out.print("작성자 id: ");
		int writerId = scanner.nextInt();

		Connection connection = DBConnection.getInstance().getConnection();

		String sql = "select * from board_mst where writer_id = ?";
		PreparedStatement pstmt;

		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, writerId);
			// writerId를 물음표로 대신한다.
			ResultSet rs = pstmt.executeQuery();

			System.out.println("id\ttitle\t\tcontent\t\t\tread_count\twriter_id");

			while (rs.next()) {
				System.out.println("id: " + rs.getInt(1) + "\ttitle: " + rs.getString(2) + "\tcontent: "
						+ rs.getString(3) + "\tread_count: " + rs.getInt(4) + "\twriter_id: " + rs.getInt(5));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

// 이렇게 Scanner를 받아 출력을 할 경우
// 내가 원하는 writer_id 숫자의 값들만 출력을 해줄 수 있다.
