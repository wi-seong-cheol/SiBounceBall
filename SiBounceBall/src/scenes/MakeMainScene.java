package scenes;

import optimizedSBB.*;
import service.*;
import dto.MapDto;

import java.util.List;

public class MakeMainScene extends Thread {
	// 새로운 Scene 추가시 lastLevel 업데이트 필수...!!!
	// 새로운 Scene 추가시 makeBall은 항상 맨처음에...!!
	public static int star=1;
	private int lastLevel = 9;
	int sceneNum = SBBMain.sceneNum;
	int n;
	UserService user = new UserService();
	public static MapService map = new MapService();
	public static List<MapDto> MapList = map.getMapList();
	
	public void run() {
		n=sceneNum;
		setScene();
		drawScene();
		while (SBBMain.isRunning) {
			if(star == 0) {
				n=-2;
				setScene();
				drawScene();
			}
			if(sceneNum != SBBMain.sceneNum) {
				n=SBBMain.sceneNum;
				setScene();
				drawScene();
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public synchronized void currentStage() {
		SBBMain.sceneNum = sceneNum;
		n = sceneNum;
	}
	
	public synchronized void nextStage() {
		if(MoveEngine.constForces.size() == 0) 
			MoveEngine.constForces.add(new Accel(0.0, SBBMain.GRAVITY));
		    // moveL or R 상태로 별을 다먹고 다음스테이지로 갈때 멈춤방지
		if(sceneNum == lastLevel)
			this.sceneNum = 1;
		else {
			System.out.println("Clear");
			
			this.sceneNum++;
			if(sceneNum > SBBMain.highestLevel + 1) {
				SBBMain.highestLevel++;
				user.updateHighestLevel(SBBMain.id,SBBMain.highestLevel);
			}
		}
		SBBMain.sceneNum = sceneNum;
		n = sceneNum;
	}
	
	public synchronized void selectedStage() {
		this.sceneNum = SBBMain.sceneNum;
	}
	
	public synchronized void setScene() {	
		MakeGameComponents.living.clear();
		SBBMain.inventory1 = false;
		SBBMain.inventory2 = false;
		
		if(n == -1) //repaint current Level
			currentStage();
		else if(n == -2) //repaint next Level
			nextStage();
		else //repaint selected Level
			selectedStage();
	}
	
	public synchronized void drawScene() {
		MapDto m = MapList.get(n-1);
		int x = m.getBallX();
		int y = m.getBallY();
		MakeGameComponents.makeBall(x,y);
		
		star = m.getStar();
		
		for(int j=0; j<20; j++) {
			char[] rowToChar = m.getRow(j).toCharArray();
			for(int i=0; i<26; i++) {
				MakeScene.makeScene(rowToChar[i], i, j);
			}
		}
	}
}