package main.java.com.study.jabc.main;

import java.sql.Connection;

import com.mysql.cj.jdbc.Driver;

import main.java.com.study.jabc.util.DBConnection;

public class jdbcTest1 {

	public static void main(String[] args) {
//		System.out.println(Driver.class.getName());
//		//경로를 찾아서 경로 이름 출력
		
		Connection connection = DBConnection.getInstance().getConnection();
		
		System.out.println(connection);
		//경로를 찾아서 경로 이름 출력
	}

}
