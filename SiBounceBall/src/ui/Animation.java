package ui;

import gamecomponents.*;
import scenes.*;
import optimizedSBB.SBBMain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Graphics;


public class Animation extends SBBMain{
		
	private static int fps = 0;
	private static int frames = 0;	
	private static long beginTime = 0;
	private static long curTime = 0;
	private static boolean showFPS = true;
	//frame 관련 변수들
	
	private static int backNum = 0;
	//백그라운드 관련 변수
	
	public Animation() {}
	
	public void runAnimation() {
		
		setFPS();
		
		while (isRunning) {
			try {	
				
				createBuffer();				
				// (1) 그래픽 버퍼 생성	
						
		        chooseBackNum(sceneNum); //sceneNum에 따라 정해진 백그라운드이미지 번호 설정.
		        drawBackground(backNum); //backNum에 따라 백그라운드 이미지 생성.
		        // (2) 백그라운드 이미지 생성		        
		        
		        drawObj(MakeGameComponents.living);
		        // (3)오브젝트 이미지 생성 		    	
		        
		    	checkFPS(curTime, showFPS);				
				// (4)일정 시간마다 프레임 초기화 및 출력
		    	
				drawBuffer();				
				showBuffer();
				// (5) 그래픽 버퍼에 저장된 이미지들을 출력							
				
				Thread.sleep(15);				
			}//try
			
			catch (InterruptedException e) {}
			
			finally {
				// release resources
				disposeGraphics(graphics);
				disposeG2D(g2d);
			}
			
		}//while문 종료
		
	}
	
	

	  public static void createBuffer() {
		  g2d = buffer.createGraphics();
	  }

	  public static void drawBuffer() {
			graphics = b.getDrawGraphics();
			graphics.drawImage(buffer, 0, 0, null);  	  
	  }
	  
	  public static void showBuffer() {
			if (!b.contentsLost()) 
				b.show();
			//BufferStrategy b;
	  } 	   
	  
	  
	  public static void chooseBackNum(int sceneNum){
    	  switch(sceneNum) {	      	     
	      	case 1: case 4: case 7: 
	      		backNum = 0;
	      		break;
	      	case 2: case 5: case 6:
	       		backNum = 1;
	      		break;
	      	case 3: case 8:
	       		backNum = 2;
	      		break;
	      	default:
	       		backNum = 0;     			     	
    	  }	
	  }

	  public static void setBackNum(int num){
		  backNum = num;  
	  }
	  
	  public static void drawBackground(int backNum){
			g2d.drawImage(background.get(backNum), 0,0, null);
	  }
	  

	  public static void setFPS() { 
		curTime = System.currentTimeMillis();
		beginTime = curTime;
	  }
		
	  public static void checkFPS(long curtime, boolean show) {
		   curTime = System.currentTimeMillis();
		   
		   long _totalTime = curTime - beginTime;
		   
		   if(_totalTime > 1000) {
		 	  beginTime = curTime;
		 	  fps = frames;
		 	  frames = 0;	
		   }
		   
		   frames++;
	    	
		   if(show == true)
			   drawFPS(g2d);		
	  }
	  
	  public static void drawFPS(Graphics2D g2d) {
			g2d.setFont(new Font("Courier New", Font.PLAIN, 12));
			g2d.setColor(Color.GREEN);
			g2d.drawString(String.format("FPS: %s", fps), 20, 20);
	 }

	  public static void setShowFPS(boolean show) {
		if(show==true)
			showFPS = true;
		else
			showFPS = false;	  
	  }
	  
	  
	  
	  public static void drawObj(ArrayList<Spawn> obj) {

	        for (int i = 0; i < obj.size(); i++) {
	          try {
				at.translate(obj.get(i).getX(), obj.get(i).getY());
			    Spawn spawn = obj.get(i);
	        	  drawObjImage(spawn);		            		              
	          }
	          catch (Exception e) {
	        	  continue;
	          }		          
	        }	      
	        
	  }
	  
	  public static void drawObjImage(Spawn s){
		  if(s instanceof SpawnBall) { 
	    	  g2d.drawImage(sibaball2,(int) (s.getX() )+4,(int) (s.getY() ), c);
	      }
	      else if(s instanceof SpawnWall){
	    	  g2d.drawImage(wallImage.get(s.num-1),(int) (s.getX() ),(int) (s.getY() ), c);            	  
	      }
	      else if(s instanceof SpawnThorn) {
	    	  g2d.drawImage(thorn.get(s.num-1),(int) (s.getX() ),(int) (s.getY() ), c);
	      }
	      else if(s instanceof SpawnJump) {
	    	  g2d.drawImage(jump,(int) (s.getX() ),(int) (s.getY() ), c);
	      }
	      else if(s instanceof SpawnElectricity) {
	    	  g2d.drawImage(electricity,(int) (s.getX() ),(int) (s.getY() ), c);
	      }
	      else if(s instanceof SpawnDashItem) {
	    	  g2d.drawImage(item1,(int) (s.getX() ),(int) (s.getY() ), c);
	      }
	      else if(s instanceof SpawnJumpItem) {
	    	  g2d.drawImage(item2,(int) (s.getX() ),(int) (s.getY() ), c);
	      }
	      else if(s instanceof SpawnStar) {
	    	  g2d.drawImage(star,(int) (s.getX() ),(int) (s.getY() ), c);
	      }
	      else if(s instanceof SpawnBreakable) {
	    	  g2d.drawImage(breakable,(int) (s.getX() ),(int) (s.getY() ), c);
	      }
	      else if(s instanceof SpawnMoveL) {
	    	  g2d.drawImage(moveL,(int) (s.getX() ),(int) (s.getY() ), c);
	      }
	      else if(s instanceof SpawnMoveR) {
	    	  g2d.drawImage(moveR,(int) (s.getX() ),(int) (s.getY() ), c);
	      }
	  }



	  public static void disposeGraphics(Graphics _graphics) {
			if (graphics != null) 
				graphics.dispose();
	  }
	  
	  public static void disposeG2D(Graphics2D _g2d) {
			if (g2d != null) 
				g2d.dispose();
	  }
}
	  
