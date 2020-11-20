package scenes;

public class MakeScene7 extends MakeGameComponents{
	int i;
	public void makeScene() {
		MakeMainScene.star = 7;
		makeBall(370, 20);
		  
		makeWall(370, 130, 3);
		makeWall(370, 160, 3);
		  
		for(i=0; i<3; i++) makeStar(370, 190 + i*30);
		makeWall(370, 280, 3);
		makeWall(370, 310, 3);
		
		for(i=0; i<2; i++) makeStar(370, 340 + i*30);
		makeDashItem(370,400);
		makeWall(370, 430, 3);
		
		makeThorn(250, 460, 3);
		makeElectricity(280, 460);
		for(i=0; i<5; i++) makeWall(310 + i*30, 460, 3); makeElectricity(370, 460);
		makeElectricity(460, 460);
		makeThorn(490, 460, 3);
		  
		for(i=0; i<2; i++) makeStar(370, 490 + i*30);
		makeWall(370, 550, 3);
	}
}
