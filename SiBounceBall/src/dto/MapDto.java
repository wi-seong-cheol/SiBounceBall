package dto;

public class MapDto {

	int level; // ���� ������ ������
	int star;
	int ballX; // makeBall() x ��ǥ
	int ballY; // makeBall() y ��ǥ
	String[] rows = new String[26]; // 26bit String�� ����.
	
	public MapDto() {}
	
	public MapDto(int level,int star, int ballX, int ballY, String[] rows) {
		this.level = level;
		this.star  = star;
		this.ballX = ballX;
		this.ballY = ballY;
		this.rows  = rows;
	}
	
	// getter
	public int getLevel() {
		return level;
	}
	public int getStar() {
		return star;
	}
	public int getBallX() {
		return ballX;
	}
	public int getBallY() {
		return ballY;
	}
	public String[] getRows() {
		return rows;
	}
	
	
	//setter
	public void setLevel(int level) {
		this.level = level;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public void setBallX(int ballX) {
		this.ballX = ballX;
	}
	public void setBallY(int ballY) {
		this.ballY = ballY;
	}
	public void setRows(String[] rows) {
		this.rows = rows;
	}
	

	
	/*
	
	0 : no block
	1 : wall
	2 : jump
	3 : thorn
	4 : electricity
	5 : item1
	6 : item2
	7 : star
	8 : breakable
	9 : moveL
	A : moveR
	
	*/
	
	
	
}
