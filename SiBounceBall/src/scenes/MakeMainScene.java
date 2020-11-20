package scenes;

import OptimizedSBB.*;
import service.*;

public class MakeMainScene extends Thread {
	// 새로운 Scene 추가시 lastLevel 업데이트 필수...!!!
	// 새로운 Scene 추가시 makeBall은 항상 맨처음에...!!!
	public static int star=1;
	private int lastLevel = 9;
	MakeScene1 s1 = new MakeScene1();
	MakeScene2 s2 = new MakeScene2();
	MakeScene3 s3 = new MakeScene3();
	MakeScene4 s4 = new MakeScene4();
	MakeScene5 s5 = new MakeScene5();
	MakeScene6 s6 = new MakeScene6();
	MakeScene7 s7 = new MakeScene7();
	MakeScene8 s8 = new MakeScene8();
	MakeScene9 s9 = new MakeScene9();
	int sceneNum = SBBMain.sceneNum;
	int n;
	UserService user = new UserService();
	
	public void run() {
		n=sceneNum;
		setScene();
		showScene();
		while (SBBMain.isRunning) {
			if(star == 0) {
				n=-2;
				setScene();
				showScene();
			}
			if(sceneNum != SBBMain.sceneNum) {
				n=SBBMain.sceneNum;
				setScene();
				showScene();
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
	
	public synchronized void showScene() {
		switch(n) {
		case 1:
			s1.makeScene();
			break;
		case 2:
			s2.makeScene();
			break;
		case 3:
			s3.makeScene();
			break;
		case 4:
			s4.makeScene();
			break;
		case 5:
			s5.makeScene();
			break;
		case 6:
			s6.makeScene();
			break;
		case 7:
			s7.makeScene();
			break;
		case 8:
			s8.makeScene();
			break;
		case 9:
			s9.makeScene();
			break;
		default :
			System.out.println("Scene Number Error : "+n);
			break;
		}
	}
	
}