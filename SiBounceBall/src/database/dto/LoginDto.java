package database.dto;

public class LoginDto {
	
	String id;
	String pw;
	
	public LoginDto() {}
	
	public LoginDto(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	
	//getter
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	//setter
	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
