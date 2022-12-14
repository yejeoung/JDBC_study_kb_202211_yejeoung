package main.java.com.study.jabc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
// cj => Connection java

public class DBConnection {

	private static DBConnection instance = null;
	
	private DBConnection() {} //생성자
	
	public static DBConnection getInstance() { //싱글톤
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		String url = null;
		String username = null;
		String password = null;
		
		try {
			Class.forName(Driver.class.getName());
			//Class.forName => 드라이브 객체 생성
			System.out.println("데이터베이스 드라이브 로딩 성공!");
			
			url = "jdbc:mysql://localhost:3306/subquery_study";
			//데이터베이스 이름
			username = "root";
			password = "root";
			
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//객체 생성을 시작한다.
			System.out.println("드라이브 로딩 실패!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패!");
		}
		return connection;
	}
}
