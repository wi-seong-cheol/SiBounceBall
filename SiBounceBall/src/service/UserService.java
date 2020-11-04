package service;

import dao.UDao;
import dto.JoinDto;
import dto.LoginDto;
import dto.UserDto;

public class UserService {

	public int join(JoinDto dto) {
		int r = 0;
		try {
			r = UDao.getInstance().join(dto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return r; // 1: success  |  0 : fail 	
	}
	
	public int login(LoginDto dto) {
		int r = 0;
		try {
			r = UDao.getInstance().login(dto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return r; // 1 : success  |  0 : wrong pw   |  -1 : wrong id
	}
	
	/*
	public UserDto getUserInfo(String id) { 
		UDao dao = new UDao();
		return dao.userInfo(id);
	}
	public int getHighestLevel(String id) {
	    UDao dao = new UDao();
	    return dao.getHighestLevel(id);
	}
	   
	public void updateHighestLevel(String id) { // �쁽�옱 highestLevel++
	    UDao dao = new UDao();
	    dao.getHighestLevel(id);
	}
	public void updateHighestLevel(String id, int level) { // �쁽�옱 highestLevel�쓣 level 濡� �뾽�뜲�씠�듃
	    UDao dao = new UDao();
	    dao.updateHighestLevel(id, level);
	}
	*/
}
