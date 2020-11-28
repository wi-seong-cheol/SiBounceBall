package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dto.JoinDto;
import dto.LoginDto;
import dto.MapDto;
import dto.UserDto;

public class Dao {

	private static Dao dao;
	private DBConnector dbc = DBConnector.getInstance();
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private Dao() {}
	
	public static Dao getInstance() {
		if(dao == null) {
			dao = new Dao();
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

	
	
	public List<MapDto> getMapList() throws Exception, SQLException{
		List<MapDto> MapList  = new ArrayList<MapDto>();
		
		MapDto dto = null;

		conn = dbc.getConnection();
		
		String query = "select * from maps";
		
		pstmt = conn.prepareStatement(query);
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			int level = rs.getInt("levelNum");
			int star  = rs.getInt("star");
			int ballX = rs.getInt("ballX");
			int ballY = rs.getInt("ballY");
			String[] rows = new String[20];
			for (int i = 5; i < 25 ; i++) {
				rows[i-4] = rs.getString(i);
			}
			
			dto = new MapDto(level, star, ballX, ballY, rows);
			MapList.add(dto);
		}
		
		disconnect();
		
		return MapList;
	}
	
	
	public void disconnect() throws SQLException {
		if(rs != null) rs.close();
		pstmt.close();
		conn.close();
	}
}