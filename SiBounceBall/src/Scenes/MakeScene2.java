package Scenes;

public class MakeScene2 extends MakeGameComponents {
	int i;
	public void makeScene() {
		MakeMainScene.star = 6;
		makeBall(210, 0);
		
		for(i=0; i<3; i++)makeWall(120, i*30, 1);
		for(i=0; i<7; i++)makeWall(120 + i*30, 90, 1);

		makeWall(330, 60, 1);
		
		makeBreakable(420, 210);
		makeBreakable(300, 270);
		makeBreakable(270, 390);
		for(i=0; i<2; i++)makeThorn(330 + i*30, 330, 1);
		for(i=0; i<2; i++)makeThorn(390 + i*30, 300, 1);
		makeThorn(450, 270, 1);
		for(i=0; i<4; i++)makeThorn(480 + i*30, 240, 1);
		for(i=0; i<6; i++)makeStar(450 + i*30, 300);
		makeJump(510, 540);
		makeBreakable(570, 460);
		makeJump(660, 400);
		makeMoveL(630, 300);
		for(i=0; i<6; i++)makeThorn(330 + i*30, 570, 1);
		makeBreakable(420, 540);
		for(i=0; i<3; i++)makeThorn(240 + i*30, 540, 1);
		makeBreakable(300, 510);
		for(i=0; i<2; i++)makeThorn(180 + i*30, 510, 1);
	}
}
