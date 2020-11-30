package view;

import optimizedSBB.*;
import service.*;
import viewModel.Information;
import dto.MapDto;
import gamecomponents.*;
import model.PhysicalQuantity;
import moveengine.Accel;
import moveengine.MoveEngine;

import java.util.List;

public class MakeMainScene extends Thread {
	// 새로운 Scene 추가시 lastLevel 업데이트 필수...!!!
	// 새로운 Scene 추가시 makeBall은 항상 맨처음에...!!
	public static int star = 1;
	private int lastLevel = 9;
	Information info = new Information();
	int sceneNum = Information.getSceneNumber();
	int n;
	UserService user = new UserService();
	public static MapService map = new MapService();
	public static List<MapDto> MapList = map.getMapList();
	
	public void run() {
		n=sceneNum;
		setScene();
		buildScene();
		while (SBBMain.isRunning) {
			if(star == 0) {
				n=-2;
				setScene();
				buildScene();
			}
			if(sceneNum != Information.getSceneNumber()) {
				n=Information.getSceneNumber();
				setScene();
				buildScene();
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public synchronized void currentStage() {
		info.setSceneNumber(sceneNum);
		n = sceneNum;
	}
	
	public synchronized void nextStage() {
		if(MoveEngine.constForces.size() == 0) 
			MoveEngine.constForces.add(new Accel(0.0, PhysicalQuantity.GRAVITY));
		// moveL or R 상태로 별을 다먹고 다음스테이지로 갈때 멈춤방지
		if(sceneNum == lastLevel)
			this.sceneNum = 1;
		else {
			System.out.println("Clear");
			
			this.sceneNum++;
			if(sceneNum > Information.getHighLevel() + 1) {
				info.setHighLevel();
				user.updateHighestLevel(Information.getID(),Information.getHighLevel());
			}
		}
		info.setSceneNumber(sceneNum);
		n = sceneNum;
	}
	
	public synchronized void selectedStage() {
		this.sceneNum = Information.getSceneNumber();
	}
	
	public synchronized void setScene() {	
		MakeGameComponents.living.clear();
		info.setInventory1(false);
		info.setInventory2(false);
		
		if(n == -1) //repaint current Level
			currentStage();
		else if(n == -2) //repaint next Level
			nextStage();
		else //repaint selected Level
			selectedStage();
	}
	
	public synchronized void buildScene() {
		if(n>0 && n<9) {
			MapDto m = MapList.get(n-1);
			int x = m.getBallX();
			int y = m.getBallY();
			Spawn ball = new SpawnBall(x, y);
			MakeGameComponents.addBlock(ball);
			
			star = m.getStar();
			MakeGameComponents.setBlockType(n);
			
			for(int j=0; j<20; j++) {
				char[] rowToChar = m.getRow(j).toCharArray();
				for(int i=0; i<26; i++) {
					MakeGameComponents.makeScene(rowToChar[i], i*30, j*30);
				}
			}
		}
	}
}