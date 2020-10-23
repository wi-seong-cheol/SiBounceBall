package Scenes;

import OptimizedSBB.SBBMain;

public class MakeScene7
{
	int i;
	public void makeScene()
	{
		MakeMainScene.star = 7;
		SBBMain.makeBall(370, 20);
		  
		SBBMain.makeWall(370, 130, 3);
		SBBMain.makeWall(370, 160, 3);
		  
		for(i=0; i<3; i++) SBBMain.makeStar(370, 190 + i*30);
		SBBMain.makeWall(370, 280, 3);
		SBBMain.makeWall(370, 310, 3);
		
		for(i=0; i<2; i++) SBBMain.makeStar(370, 340 + i*30);
		SBBMain.makeItem1(370,400);
		SBBMain.makeWall(370, 430, 3);
		
		SBBMain.makeThorn(250, 460, 3);
		SBBMain.makeElectricity(280, 460);
		for(i=0; i<5; i++) SBBMain.makeWall(310 + i*30, 460, 3); SBBMain.makeElectricity(370, 460);
		SBBMain.makeElectricity(460, 460);
		SBBMain.makeThorn(490, 460, 3);
		  
		for(i=0; i<2; i++) SBBMain.makeStar(370, 490 + i*30);
		SBBMain.makeWall(370, 550, 3);
	}
}
