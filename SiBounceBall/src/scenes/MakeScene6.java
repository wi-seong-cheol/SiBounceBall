package scenes;

public class MakeScene6 extends MakeGameComponents{
	int i;
	public void makeScene() {
		 MakeMainScene.star = 27;
		  makeBall(40, 50);
		  
		  for(i=0; i<5; i++) makeStar(40, 130+i*30);
		  makeJumpItem(40, 280);
		  makeWall(130, 280, 3);
		  
		  for(i=0; i<5; i++) makeStar(180, 190+i*30);
		  makeJumpItem(180, 340);
		  makeWall(270, 340, 3);
		  
		  for(i=0; i<5; i++) makeStar(320, 250+i*30);
		  makeJumpItem(320, 400);
		  makeWall(410, 400, 3);
		  
		  for(i=0; i<5; i++) makeStar(460, 310+i*30);
		  makeJumpItem(460, 460);
		  makeWall(550, 460, 3);
		  
		  for(i=0; i<5; i++) makeStar(600, 370+i*30);
		  makeJumpItem(600, 520);
		  
		  makeWall(740, 540, 3);
		  makeStar(740, 510);
		  makeWall(770, 570, 3);
		  makeStar(770, 540);
		  
		  makeWall(30, 540, 3);
		  makeWall(0, 570, 3);
	}
}
