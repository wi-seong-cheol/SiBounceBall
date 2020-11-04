package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import conn.DBConnector;
import dto.JoinDto;
import dto.LoginDto;
import dto.UserDto;

public class UDao {

	private static UDao dao;
	private DBConnector dbc = DBConnector.getInstance();
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private UDao() {}
	
	public static UDao getInstance() {
		if(dao == null) {
			dao = new UDao();
		}
		return dao;
	}
	
	public int join(JoinDto dto) throws Exception, SQLException{

		int rn = 0;
		

		try {

			conn = dbc.getConnection();
			String query = "insert into users (id, nickname, pw) values (?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getPw());

			rn = pstmt.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			rn = 0;
		} 
		
		disconnect();

		return rn;
	}// join()
	
	public int login(LoginDto dto) throws Exception, SQLException {

		int rn = 0;

		conn = dbc.getConnection();

		String query = "select pw from users where id = ?";
			
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, dto.getId());
			
		rs = pstmt.executeQuery();

		if (rs.next()) {
			if (dto.getPw().equals(rs.getString("pw")))
				rn = 1;
			else
				rn = 0;
		} else
			rn = -1;
		
		disconnect();

		return rn;
	} // login()

	public UserDto userInfo(String uId) throws Exception, SQLException {

		UserDto dto = null;

		conn = dbc.getConnection();
		
		String query = "select * from users where id = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, uId);
			
		rs = pstmt.executeQuery();

		if (rs.next()) {
			String id = rs.getString("id");
			String nickname = rs.getString("nickname");
			int hLevel = rs.getInt("hLevel");

			dto = new UserDto(id, nickname, hLevel);
		}

		disconnect();

		return dto;
	}
	
/*
	public int getHighestLevel(String id) {
		int rsLevel = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, "scott", "tiger");

			String query = "select hLevel from users where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rsLevel = rs.getInt("hLevel");
			}
		} catch (Exception e1) {
			System.out.println("errer in getHighestELevel() - e1 : ");
			e1.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				System.out.println("errer in getHighestLevel() - e2 : ");
				e2.printStackTrace();
			}
		}

		return rsLevel;
	}
	*/
	
	public void updateHighestLevel(String id, int level) throws Exception, SQLException {

		conn = dbc.getConnection();
		
		String query = "update users set hLevel = ? where id = ?";
			
		pstmt = conn.prepareStatement(query);
		pstmt.setInt(1, level);
		pstmt.setString(2, id);

		int rn = pstmt.executeUpdate();
		System.out.println(rn);
		
		disconnect();
		
	}

	
	public void updateHighestLevel(String id) throws Exception, SQLException {

		conn = dbc.getConnection();
			
		String query = "update users set hLevel = hLevel + 1 where id = ?";
			
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);

		int rn = pstmt.executeUpdate();
		System.out.println(rn);
		
		disconnect();

	}

	
	public void disconnect() throws SQLException {
		if(rs != null) rs.close();
		pstmt.close();
		conn.close();
	}
}