package Scenes;

import OptimizedSBB.SBBMain;

public class MakeScene8
{
	int i;
	public void makeScene()
	{
		MakeMainScene.star = 15;
		SBBMain.makeBall(80, 20);
		SBBMain.makeWall(80, 90, 2);
		SBBMain.makeStar(350, 60);
		SBBMain.makeWall(350, 90, 2);
		SBBMain.makeStar(590, 60);
		SBBMain.makeWall(590, 90, 2);
		
		for(i=0;i <3; i++) SBBMain.makeElectricity(80,240+i*150);
		for(i=0; i<3; i++) SBBMain.makeStar(80, 210+ i*150);
		SBBMain.makeWall(50, 240, 2);
		SBBMain.makeWall(110, 390, 2);
		SBBMain.makeWall(50, 540, 2);
		
		SBBMain.makeJump(260, 240);
		SBBMain.makeJump(200, 390);
		SBBMain.makeJump(140, 540);
		
		for(i=0;i <3; i++) SBBMain.makeElectricity(350,240+i*150);
		for(i=0; i<3; i++) SBBMain.makeStar(350, 210+ i*150);
		SBBMain.makeBreakable(320, 270);
		SBBMain.makeBreakable(380, 420);
		SBBMain.makeBreakable(320, 570);
		
		SBBMain.makeJump(410, 570);
		SBBMain.makeJump(470, 420);
		SBBMain.makeJump(500, 270);
		
		SBBMain.makeItem2(500, 240);
		for(i=0;i <3; i++) SBBMain.makeElectricity(590,240+i*150);
		for(i=0; i<3; i++) SBBMain.makeStar(590, 210+ i*150);
		//SBBMain.makeStar(590, 180);
		SBBMain.makeItem2(620, 120);
		SBBMain.makeItem2(560, 390);
		SBBMain.makeItem2(620, 540);
		
		SBBMain.makeStar(560, 240);
		SBBMain.makeStar(620, 240);
		SBBMain.makeStar(620, 390);
		SBBMain.makeStar(560, 540);
	}
}
