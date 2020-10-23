package Scenes;

import OptimizedSBB.SBBMain;

public class MakeScene6
{
	int i;
	public void makeScene()
	{
		 MakeMainScene.star = 27;
		  SBBMain.makeBall(40, 50);
		  
		  for(i=0; i<5; i++) SBBMain.makeStar(40, 130+i*30);
		  SBBMain.makeItem2(40, 280);
		  SBBMain.makeWall(130, 280, 3);
		  
		  for(i=0; i<5; i++) SBBMain.makeStar(180, 190+i*30);
		  SBBMain.makeItem2(180, 340);
		  SBBMain.makeWall(270, 340, 3);
		  
		  for(i=0; i<5; i++) SBBMain.makeStar(320, 250+i*30);
		  SBBMain.makeItem2(320, 400);
		  SBBMain.makeWall(410, 400, 3);
		  
		  for(i=0; i<5; i++) SBBMain.makeStar(460, 310+i*30);
		  SBBMain.makeItem2(460, 460);
		  SBBMain.makeWall(550, 460, 3);
		  
		  for(i=0; i<5; i++) SBBMain.makeStar(600, 370+i*30);
		  SBBMain.makeItem2(600, 520);
		  
		  SBBMain.makeWall(740, 540, 3);
		  SBBMain.makeStar(740, 510);
		  SBBMain.makeWall(770, 570, 3);
		  SBBMain.makeStar(770, 540);
		  
		  SBBMain.makeWall(30, 540, 3);
		  SBBMain.makeWall(0, 570, 3);
	}
}
