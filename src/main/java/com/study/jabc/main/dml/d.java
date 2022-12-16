package main.java.com.study.jabc.main.dml;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d {
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
	}
}
