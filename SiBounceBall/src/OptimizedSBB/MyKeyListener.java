package OptimizedSBB;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Objects.*;

public class MyKeyListener implements KeyListener {

	public void keyPressed(KeyEvent e) {
  		int keyCode = e.getKeyCode();

  		
  		if (keyCode == KeyEvent.VK_SPACE) {
  			if(SBBMain.inventory1) {
				if(SBBMain.isPressed1) {
					SpawnBall.vx = -680;
					SpawnBall.vy = -250;
					SBBMain.inventory1 = false;
				}
				else if(SBBMain.isPressed2) {
					SpawnBall.vx = 680;
					SpawnBall.vy = -250;
					SBBMain.inventory1 = false;
				}
				else System.out.println("Press UP key while RIGHT or LEFT key is active."); 
			}
        }
  		if(keyCode == KeyEvent.VK_1) {
  			if(SBBMain.sceneNum == 1) SBBMain.sceneNum = -1;
  			else SBBMain.sceneNum = 1;
  		}
  		if(keyCode == KeyEvent.VK_2) {
  			if(SBBMain.sceneNum == 2) SBBMain.sceneNum = -1;
  			else SBBMain.sceneNum = 2;
  		}
  		if(keyCode == KeyEvent.VK_3) {
  			if(SBBMain.sceneNum == 3) SBBMain.sceneNum = -1;
  			else SBBMain.sceneNum = 3;
  		}
  		if(keyCode == KeyEvent.VK_4) {
  			if(SBBMain.sceneNum == 4) SBBMain.sceneNum = -1;
  			else SBBMain.sceneNum = 4;
  		}
  		if(keyCode == KeyEvent.VK_5) {
  			if(SBBMain.sceneNum == 5) SBBMain.sceneNum = -1;
  			else SBBMain.sceneNum = 5;
  		}
  		if(keyCode == KeyEvent.VK_6) {
  			if(SBBMain.sceneNum == 6) SBBMain.sceneNum = -1;
  			else SBBMain.sceneNum = 6;
  		}
  		if(keyCode == KeyEvent.VK_7) {
  			if(SBBMain.sceneNum == 7) SBBMain.sceneNum = -1;
  			else SBBMain.sceneNum = 7;
  		}
  		if(keyCode == KeyEvent.VK_8) {
  			if(SBBMain.sceneNum == 8) SBBMain.sceneNum = -1;
  			else SBBMain.sceneNum = 8;
  		}
  		if(keyCode == KeyEvent.VK_9) {
  			if(SBBMain.sceneNum == 9) SBBMain.sceneNum = -1;
  			else SBBMain.sceneNum = 9;
  		}
  		
  		switch(keyCode) {
			case KeyEvent.VK_LEFT : {
				if(MoveEngine.constForces.size()==0)
					MoveEngine.constForces.add(new Accel(0.0, SBBMain.GRAVITY));
				SBBMain.isPressed1 = true;
				SpawnBall.vx = -180;
				break;
			}
			case KeyEvent.VK_RIGHT : {
				if(MoveEngine.constForces.size()==0)
					MoveEngine.constForces.add(new Accel(0.0, SBBMain.GRAVITY)); 
				SBBMain.isPressed2 = true;
				SpawnBall.vx = 180;
				break;
			}
			case KeyEvent.VK_UP : {
				if(SBBMain.inventory2) {
					SpawnBall.vy = -600;
					SBBMain.inventory2 = false;
				}
				break;
			}
			case KeyEvent.VK_DOWN :
				break;
			default :
				break;
		}
  	}
	public void keyReleased(KeyEvent e) {
        
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT :{
				if(SBBMain.isPressed2 == true && MoveEngine.constForces.size()!=0) 
					SpawnBall.vx = 150;
				else if(MoveEngine.constForces.size()!=0)
					SpawnBall.vx=0;
				SBBMain.isPressed1 = false;
				break;
			}
			case KeyEvent.VK_RIGHT :{
				if(SBBMain.isPressed1 == true && MoveEngine.constForces.size()!=0) 
					SpawnBall.vx = -150;
				else if(MoveEngine.constForces.size()!=0)
					SpawnBall.vx=0;
				SBBMain.isPressed2 = false;
				break;
			}
			case KeyEvent.VK_UP :
				break;
			case KeyEvent.VK_DOWN :
				break;
		}
    }
	
	public void keyTyped(KeyEvent e) {}
	
}
