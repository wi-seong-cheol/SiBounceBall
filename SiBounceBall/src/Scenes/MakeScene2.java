package Scenes;

import OptimizedSBB.SBBMain;

public class MakeScene2
{
	int i;
	public void makeScene()
	{
		MakeMainScene.star = 6;
		SBBMain.makeBall(210, 0);
		
		for(i=0; i<3; i++)SBBMain.makeWall(120, i*30, 1);
		for(i=0; i<7; i++)SBBMain.makeWall(120 + i*30, 90, 1);

		SBBMain.makeWall(330, 60, 1);
		
		SBBMain.makeBreakable(420, 210);
		SBBMain.makeBreakable(300, 270);
		SBBMain.makeBreakable(270, 390);
		for(i=0; i<2; i++)SBBMain.makeThorn(330 + i*30, 330, 1);
		for(i=0; i<2; i++)SBBMain.makeThorn(390 + i*30, 300, 1);
		SBBMain.makeThorn(450, 270, 1);
		for(i=0; i<4; i++)SBBMain.makeThorn(480 + i*30, 240, 1);
		for(i=0; i<6; i++)SBBMain.makeStar(450 + i*30, 300);
		SBBMain.makeJump(510, 540);
		SBBMain.makeBreakable(570, 460);
		SBBMain.makeJump(660, 400);
		SBBMain.makeMoveL(630, 300);
		for(i=0; i<6; i++)SBBMain.makeThorn(330 + i*30, 570, 1);
		SBBMain.makeBreakable(420, 540);
		for(i=0; i<3; i++)SBBMain.makeThorn(240 + i*30, 540, 1);
		SBBMain.makeBreakable(300, 510);
		for(i=0; i<2; i++)SBBMain.makeThorn(180 + i*30, 510, 1);
	}
}
