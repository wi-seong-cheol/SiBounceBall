package Scenes;

public class MakeScene4 extends MakeGameComponents{
	int i;
	public void makeScene() {
		MakeMainScene.star = 3;
		makeBall(210, 270);
		
		makeThorn(360, 150, 4);
		for(i=0; i<6; i++)makeWall(360, 330 - i*30, 4);
		makeMoveL(330, 360);
		makeWall(300, 390, 4);
		for(i=0; i<2; i++)makeThorn(240 + i*30, 420, 4);
		for(i=0; i<2; i++)makeWall(180 + i*30, 390, 4);
		for(i=0; i<2; i++)makeThorn(120 + i*30, 390, 4);
		for(i=0; i<2; i++)makeWall(60 + i*30, 390, 4);
		makeJump(30, 360);
		makeWall(0, 390, 4);
		makeWall(120, 210, 4);
		for(i=0; i<4; i++)makeWall(150, 300 - i*30, 4);
		makeJump(90, 240);
		for(i=0; i<4; i++)makeBreakable(150+ i*60, 120);
		
		makeThorn(390, 360, 4);
		for(i=0; i<2; i++)makeThorn(450 + i*30, 300, 4);
		makeMoveR(420, 270);
		for(i=0; i<3; i++)makeThorn(480 + i*30, 210, 4);
		makeThorn(480, 150, 4);
		makeMoveL(600, 330);
		for(i=0; i<3; i++)makeWall(660 + i*30, 300, 4);
		makeStar(750, 240);
		makeThorn(630, 360, 4);
		for(i=0; i<3; i++)makeThorn(510 + i*30, 420, 4);
		
		for(i=0; i<3; i++)makeWall(390 + i*30, 510, 4);
		makeItem1(420, 480);
		for(i=0; i<3; i++)makeWall(150 + i*30, 510, 4);
		for(i=0; i<2; i++)makeStar(180, 480 - i*30);
	}
}
