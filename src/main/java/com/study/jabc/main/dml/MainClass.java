package main.java.com.study.jabc.main.dml;

import main.java.com.study.jabc.entity.User;

public class MainClass {
	public static void main(String[] args) {
		
		UserDao dao = new UserDao();
		
		User user = User.builder()
				.username("abcd")
				.build();
		
		int result = dao.insertUser(user);
		System.out.println(result > 0 ? "user_id [" + user.getUser_id() + "등록완료!" : "등록실패!");
	
	}
}
