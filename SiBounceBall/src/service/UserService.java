package service;

import dao.Dao;
import dto.JoinDto;
import dto.LoginDto;
import dto.UserDto;

public class UserService {

	public int join(JoinDto dto) {
		int r = 0;
		try {
			r = Dao.getInstance().join(dto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return r; // 1: success  |  0 : fail 	
	}
	
	public int login(LoginDto dto) {
		int r = 0;
		try {
			r = Dao.getInstance().login(dto);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return r; // 1 : success  |  0 : wrong pw   |  -1 : wrong id
	}
	
	public UserDto getUserInfo(String id) { 
		UserDto dto = null;
		try {
			dto = Dao.getInstance().userInfo(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public int getHighestLevel(String id) {
		UserDto dto = null;
		try {
			dto = Dao.getInstance().userInfo(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto.getStage();
	}
	
	public void updateHighestLevel(String id) { // highestLevel++
	    try {
	    	Dao.getInstance().updateHighestLevel(id);
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public void updateHighestLevel(String id, int level) { // update highestLevel to 'level'
		try {
	    	Dao.getInstance().updateHighestLevel(id, level);
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
}
