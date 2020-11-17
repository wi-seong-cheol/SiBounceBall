package Scenes;

public class MakeScene8 extends MakeGameComponents{
	int i;
	public void makeScene() {
		MakeMainScene.star = 15;
		makeBall(80, 20);
		makeWall(80, 90, 2);
		makeStar(350, 60);
		makeWall(350, 90, 2);
		makeStar(590, 60);
		makeWall(590, 90, 2);
		
		for(i=0;i <3; i++) makeElectricity(80,240+i*150);
		for(i=0; i<3; i++) makeStar(80, 210+ i*150);
		makeWall(50, 240, 2);
		makeWall(110, 390, 2);
		makeWall(50, 540, 2);
		
		makeJump(260, 240);
		makeJump(200, 390);
		makeJump(140, 540);
		
		for(i=0;i <3; i++) makeElectricity(350,240+i*150);
		for(i=0; i<3; i++) makeStar(350, 210+ i*150);
		makeBreakable(320, 270);
		makeBreakable(380, 420);
		makeBreakable(320, 570);
		
		makeJump(410, 570);
		makeJump(470, 420);
		makeJump(500, 270);
		
		makeItem2(500, 240);
		for(i=0;i <3; i++) makeElectricity(590,240+i*150);
		for(i=0; i<3; i++) makeStar(590, 210+ i*150);
		//makeStar(590, 180);
		makeItem2(620, 120);
		makeItem2(560, 390);
		makeItem2(620, 540);
		
		makeStar(560, 240);
		makeStar(620, 240);
		makeStar(620, 390);
		makeStar(560, 540);
	}
}
