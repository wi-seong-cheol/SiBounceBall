package database.dto;

public class UserDto {

	String id; //pk
	String nickname;
	int stage;
	
	public UserDto() {}
	
	public UserDto(String id, String nickname, int stage) {
		this.id = id;
		this.nickname = nickname;
		this.stage = stage;
	}
	
	// getter
	public String getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}
	
	public int getStage() {
		return stage;
	}
	
	// setter
	public void setId(String id) {
		this.id = id;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}	
	
	public void setStage(int stage) {
		this.stage = stage;
	}
}
