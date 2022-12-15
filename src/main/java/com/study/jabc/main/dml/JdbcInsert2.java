package main.java.com.study.jabc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.study.jabc.util.DBConnection;

public class JdbcInsert2 {
	public static void main(String[] args) {
		/*Scanner로 추가할 데이터 값을 받아서 user_mst 데이터에 여러 개의 데이터 값들을 넣을 수 있도록 하여라.*/
		Scanner scanner = new Scanner(System.in);
		List<String> usernameList = new ArrayList<>();

		while (true) {
			System.out.print("등록할 아이디 입력: ");
			usernameList.add(scanner.nextLine());
			System.out.print("아이디를 추가로 등록하시겠습니까? (Y/y, 취소하려면 아무키나 입력하세요.)");
			String selected = scanner.nextLine();
			if (!"yY".contains(selected.isBlank() ? "n" : selected)) {
				//비어있으면 "n"이라는 문자열이 있는지 확인하고
				//비어있지 않으면 입력 받아서 출력(selected가 scanner를 받는 변수)
				break;
			}
		}
		
//		System.out.println(usernameList);
		
		Connection con = DBConnection.getInstance().getConnection();
		String prefixSql = "insert into user_mst values";
		String valuesBody = "";
		String suffixSql = ";";
		
		for(int i = 0; i < usernameList.size(); i++) {
			valuesBody += "(0, ?)";
			if(i < usernameList.size() - 1) { // 맨 마지막에 쉼표가 찍히면 안 되기 때문에 쓰는 조건문
				valuesBody += ", ";
			}
		}
		System.out.println(valuesBody);
		
		// 출력을 하면 물음표가 들어가게 되는데 그 공간에 입력한 아이디들을 들어가게 할 것이다.
		try {
			PreparedStatement pstmt = con.prepareStatement(prefixSql + valuesBody + suffixSql);
			// 최종적인 SQL
			for(int i = 0; i < usernameList.size(); i++) {
				pstmt.setString(i + 1, usernameList.get(i));
				// i + 1 컬럼 1번부터 시작
				// usernameList.get(i)를 함으로써 id 컬럼이 1씩 증가하면서 차례대로 들어가게 된다.
			}
			int successCount = pstmt.executeUpdate();
			System.out.println(successCount + "건 등록완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(usernameList);
	}
}

// workbenchs에 데이터에 값들이 들어간 것을 확인할 수 있다.