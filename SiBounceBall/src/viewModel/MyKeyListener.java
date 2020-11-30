package viewModel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gamecomponents.*;
import model.*;
import moveengine.Accel;
import moveengine.MoveEngine;

public class MyKeyListener implements KeyListener {

	public void keyPressed(KeyEvent e) {
  		int keyCode = e.getKeyCode();

  		if (keyCode == KeyEvent.VK_SPACE) {
  			if(Items.inventory1) {
				if(KeyPress.isPressed1) {
					SpawnBall.vx = -680;
					SpawnBall.vy = -250;
					Items.inventory1 = false;
				}
				else if(KeyPress.isPressed2) {
					SpawnBall.vx = 680;
					SpawnBall.vy = -250;
					Items.inventory1 = false;
				}
				else System.out.println("Press UP key while RIGHT or LEFT key is active."); 
			}
        }
  		
  		switch(keyCode) {
			case KeyEvent.VK_LEFT : {
				if(MoveEngine.constForces.size()==0)
					MoveEngine.constForces.add(new Accel(0.0, PhysicalQuantity.GRAVITY));
				KeyPress.isPressed1 = true;
				SpawnBall.vx = -180;
				break;
			}
			case KeyEvent.VK_RIGHT : {
				if(MoveEngine.constForces.size()==0)
					MoveEngine.constForces.add(new Accel(0.0, PhysicalQuantity.GRAVITY)); 
				KeyPress.isPressed2 = true;
				SpawnBall.vx = 180;
				break;
			}
			case KeyEvent.VK_UP : {
				if(Items.inventory2) {
					SpawnBall.vy = -600;
					Items.inventory2 = false;
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
				if(KeyPress.isPressed2 == true && MoveEngine.constForces.size()!=0) 
					SpawnBall.vx = 150;
				else if(MoveEngine.constForces.size()!=0)
					SpawnBall.vx=0;
				KeyPress.isPressed1 = false;
				break;
			}
			case KeyEvent.VK_RIGHT :{
				if(KeyPress.isPressed1 == true && MoveEngine.constForces.size()!=0) 
					SpawnBall.vx = -150;
				else if(MoveEngine.constForces.size()!=0)
					SpawnBall.vx=0;
				KeyPress.isPressed2 = false;
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
