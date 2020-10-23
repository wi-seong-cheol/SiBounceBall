package Scenes;

import OptimizedSBB.SBBMain;

public class MakeScene1
{
	int i;
  public void makeScene()
  {
	  	MakeMainScene.star = 8;
		SBBMain.makeBall(120, 100);
		
		for(i=0; i<3; i++)SBBMain.makeWall(60, 120 + i*30, 4);
		for(i=0; i<4; i++)SBBMain.makeWall(60, 240 + i*30, 4);
		for(i=0; i<4; i++)SBBMain.makeWall(90 + i*30, 210, 4);
		for(i=0; i<3; i++)SBBMain.makeWall(180, 240 + i*30, 4);
		for(i=0; i<3; i++)SBBMain.makeWall(90 + i*30, 360, 4);
		SBBMain.makeThorn(180, 360, 4);
		for(i=0;i <4; i++)SBBMain.makeStar(90+ i*30, 330);
		
		for(i=0; i<10; i++)SBBMain.makeBreakable(300+ i*30, 330);
		for(i=0; i<10; i++) SBBMain.makeThorn(300+ i*30, 360, 4);
		for(i=0; i<4; i++)SBBMain.makeStar(300+ i*90, 300);
		
		SBBMain.makeJump(600, 360);
		SBBMain.makeMoveL(690, 330);
		SBBMain.makeThorn(720, 330, 4);
  }
}
