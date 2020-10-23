package service;

import dao.UDao;
import dto.JoinDto;
import dto.LoginDto;
import dto.UserDto;

public class UserService {

	public int join(JoinDto dto) {
		UDao dao = new UDao();
		return dao.join(dto); // 1: 회원가입 성공   |  0 : 중복된 아이디 존재  	
	}
	
	public int login(LoginDto dto) {
		UDao dao = new UDao();
		return dao.login(dto); // 1 : 로그인 성공   |  0 : pw가 틀림   |  -1 : id 존재하지 않음
	}
	
	public UserDto getUserInfo(String id) { 
		UDao dao = new UDao();
		return dao.userInfo(id);
	}
	public int getHighestLevel(String id) {
	    UDao dao = new UDao();
	    return dao.getHighestLevel(id);
	}
	   
	public void updateHighestLevel(String id) { // 현재 highestLevel++
	    UDao dao = new UDao();
	    dao.getHighestLevel(id);
	}
	public void updateHighestLevel(String id, int level) { // 현재 highestLevel을 level 로 업데이트
	    UDao dao = new UDao();
	    dao.updateHighestLevel(id, level);
	}
}
