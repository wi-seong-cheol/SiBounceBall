package database.dto;

public class MapDto {
	int level; // 무슨 레벨의 맵인지
	int star;
	int ballX; // makeBall() x 좌표
	int ballY; // makeBall() y 좌표
	String[] rows = new String[20]; // 20개의 String 배열
	
	public MapDto() {
		for(int i=0; i < 20; i++) {
			rows[i] = "00000000000000000000000000";
		}
	}
	
	public MapDto(int level, int star, int ballX, int ballY, String[] rows) {
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
	public String getRow(int row) {
		return rows[row];
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
	
	public void setRow(int row, String str) {
		rows[row] = str;
	}
	
//	public void setBlock(int row, int column, char blockNum) {
//		String tmp = this.rows[row];
//		tmp.charAt(column) = blockNum;
//	}
	
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
