package Scenes;

public class MakeScene5 extends MakeGameComponents{	
	int i;
	public void makeScene() {
		MakeMainScene.star = 26;
		makeBall(30, 60);
		
		for(i=0; i<2; i++) makeWall(0+i*30, 150, 5);
		makeBreakable(120, 150);
		makeItem1(120, 120);
		for(i=0; i<2; i++)makeWall(210+i*30, 150, 5);
		for(i=0; i<6; i++)makeElectricity(270+i*30, 150);
		for(i=0; i<6; i++)makeStar(330+i*30, 60);
		for(i=0; i<2; i++)makeStar(510+i*30, 90);
		
		for(i=0; i<2; i++) makeWall(770-i*30, 320, 5);
		makeItem1(740, 290);
		makeBreakable(650, 320);
		for(i=0; i<2; i++)makeWall(560-i*30, 320, 5);
		for(i=0; i<6; i++)makeElectricity(500-i*30, 320);
		for(i=0; i<6; i++)makeStar(440-i*30, 230);
		for(i=0; i<2; i++)makeStar(260-i*30, 260);
		
		for(i=0; i<2; i++) makeWall(0+i*30, 520, 5);
		makeBreakable(120, 520);
		makeItem1(30, 490);
		for(i=0; i<2; i++)makeWall(210+i*30, 520, 5);
		for(i=0; i<6; i++)makeElectricity(270+i*30, 520);
		for(i=0; i<6; i++)makeStar(330+i*30, 430);
		for(i=0; i<2; i++)makeStar(510+i*30, 460);
		for(i=0; i<2; i++)makeStar(570+i*30, 490);
	}
}
