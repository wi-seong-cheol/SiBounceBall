package Scenes;

import OptimizedSBB.SBBMain;

public class MakeScene5
{	
	int i;
	public void makeScene()
	{
		MakeMainScene.star = 26;
		SBBMain.makeBall(30, 60);
		
		for(i=0; i<2; i++) SBBMain.makeWall(0+i*30, 150, 5);
		SBBMain.makeBreakable(120, 150);
		SBBMain.makeItem1(120, 120);
		for(i=0; i<2; i++)SBBMain.makeWall(210+i*30, 150, 5);
		for(i=0; i<6; i++)SBBMain.makeElectricity(270+i*30, 150);
		for(i=0; i<6; i++)SBBMain.makeStar(330+i*30, 60);
		for(i=0; i<2; i++)SBBMain.makeStar(510+i*30, 90);
		
		for(i=0; i<2; i++) SBBMain.makeWall(770-i*30, 320, 5);
		SBBMain.makeItem1(740, 290);
		SBBMain.makeBreakable(650, 320);
		for(i=0; i<2; i++)SBBMain.makeWall(560-i*30, 320, 5);
		for(i=0; i<6; i++)SBBMain.makeElectricity(500-i*30, 320);
		for(i=0; i<6; i++)SBBMain.makeStar(440-i*30, 230);
		for(i=0; i<2; i++)SBBMain.makeStar(260-i*30, 260);
		
		for(i=0; i<2; i++) SBBMain.makeWall(0+i*30, 520, 5);
		SBBMain.makeBreakable(120, 520);
		SBBMain.makeItem1(30, 490);
		for(i=0; i<2; i++)SBBMain.makeWall(210+i*30, 520, 5);
		for(i=0; i<6; i++)SBBMain.makeElectricity(270+i*30, 520);
		for(i=0; i<6; i++)SBBMain.makeStar(330+i*30, 430);
		for(i=0; i<2; i++)SBBMain.makeStar(510+i*30, 460);
		for(i=0; i<2; i++)SBBMain.makeStar(570+i*30, 490);
	}
}
