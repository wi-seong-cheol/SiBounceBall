package database.dto;

public class JoinDto {

	String id;
	String nickname;
	String pw;
	
	public JoinDto() {}
	
	public JoinDto(String nickname, String id, String pw){
		this.nickname = nickname;
		this.id = id;
		this.pw = pw;
	}

	//getter

	public String getNickname() {
		return nickname;
	}

	public String getId() {
		return id;
	}
	
	public String getPw() {
		return pw;
	}

	//setter

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
