package main.java.com.study.jabc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.RequiredArgsConstructor;
import main.java.com.study.jabc.entity.User;
import main.java.com.study.jabc.util.DBConnectionMgr;

@RequiredArgsConstructor
// Args가 필수
public class UserDao {

//	private final DBConnectionMgr pool;

//	public UserDao(DBConnectionMgr pool) { //@RequiredArgsConstructor
//		this.pool = pool;
//		// pool -> 값의 대입이 필수인 키워드, DI
//	}
	// 싱글톤은 외부에서 바로 가져다 쓸 수 있기 때문에 DI를 사용하지 않는다.

	private DBConnectionMgr pool;

//	public UserDao() {
//		pool = DBConnectionMgr.getInstance(); //싱글톤
//	} //@RequiredArgsConstructor

	public int insertUser(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int successCount = 0;

		try {
			con = pool.getConnection();
			sql = "insert into user_mst values(0, ?)";
			// auto increment 값으로 insert
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			successCount = pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();
			// auto increment된 값을 찾아준다.
			if (rs.next()) {
				user.setUser_id(rs.getInt(1));
				// 키 값을 user에 Set 해준다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
			// DB 관련 객체들을 freeConnection 해주면 커넥션을 끊어줌으로써
			// 객체들이 사라진다.
		}
		return successCount;
	}
}
