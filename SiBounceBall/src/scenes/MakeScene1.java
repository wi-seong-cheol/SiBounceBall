package scenes;

public class MakeScene1 extends MakeGameComponents{
	int i;
  public void makeScene() {
	  	MakeMainScene.star = 8;
		makeBall(120, 100);
		
		for(i=0; i<3; i++)makeWall(60, 120 + i*30, 4);
		for(i=0; i<4; i++)makeWall(60, 240 + i*30, 4);
		for(i=0; i<4; i++)makeWall(90 + i*30, 210, 4);
		for(i=0; i<3; i++)makeWall(180, 240 + i*30, 4);
		for(i=0; i<3; i++)makeWall(90 + i*30, 360, 4);
		makeThorn(180, 360, 4);
		for(i=0;i <4; i++)makeStar(90+ i*30, 330);
		
		for(i=0; i<10; i++)makeBreakable(300+ i*30, 330);
		for(i=0; i<10; i++) makeThorn(300+ i*30, 360, 4);
		for(i=0; i<4; i++)makeStar(300+ i*90, 300);
		
		makeJump(600, 360);
		makeMoveL(690, 330);
		makeThorn(720, 330, 4);
  }
}
