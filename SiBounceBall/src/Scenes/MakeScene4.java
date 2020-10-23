package Scenes;

import OptimizedSBB.SBBMain;

public class MakeScene4
{
	int i;
	public void makeScene()
	{
		MakeMainScene.star = 3;
		SBBMain.makeBall(210, 270);
		
		SBBMain.makeThorn(360, 150, 4);
		for(i=0; i<6; i++)SBBMain.makeWall(360, 330 - i*30, 4);
		SBBMain.makeMoveL(330, 360);
		SBBMain.makeWall(300, 390, 4);
		for(i=0; i<2; i++)SBBMain.makeThorn(240 + i*30, 420, 4);
		for(i=0; i<2; i++)SBBMain.makeWall(180 + i*30, 390, 4);
		for(i=0; i<2; i++)SBBMain.makeThorn(120 + i*30, 390, 4);
		for(i=0; i<2; i++)SBBMain.makeWall(60 + i*30, 390, 4);
		SBBMain.makeJump(30, 360);
		SBBMain.makeWall(0, 390, 4);
		SBBMain.makeWall(120, 210, 4);
		for(i=0; i<4; i++)SBBMain.makeWall(150, 300 - i*30, 4);
		SBBMain.makeJump(90, 240);
		for(i=0; i<4; i++)SBBMain.makeBreakable(150+ i*60, 120);
		
		SBBMain.makeThorn(390, 360, 4);
		for(i=0; i<2; i++)SBBMain.makeThorn(450 + i*30, 300, 4);
		SBBMain.makeMoveR(420, 270);
		for(i=0; i<3; i++)SBBMain.makeThorn(480 + i*30, 210, 4);
		SBBMain.makeThorn(480, 150, 4);
		SBBMain.makeMoveL(600, 330);
		for(i=0; i<3; i++)SBBMain.makeWall(660 + i*30, 300, 4);
		SBBMain.makeStar(750, 240);
		SBBMain.makeThorn(630, 360, 4);
		for(i=0; i<3; i++)SBBMain.makeThorn(510 + i*30, 420, 4);
		
		for(i=0; i<3; i++)SBBMain.makeWall(390 + i*30, 510, 4);
		SBBMain.makeItem1(420, 480);
		for(i=0; i<3; i++)SBBMain.makeWall(150 + i*30, 510, 4);
		for(i=0; i<2; i++)SBBMain.makeStar(180, 480 - i*30);
	}
}
