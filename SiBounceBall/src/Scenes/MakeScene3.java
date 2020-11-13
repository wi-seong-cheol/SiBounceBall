package Scenes;

public class MakeScene3 extends MakeGameComponents{
   int i;
   public void makeScene() {
      MakeMainScene.star = 2;
        makeBall(320, 150);
        makeItem1(150, 900);
        for(i=0; i<11; i++) makeWall(150, 120+ 30*i, 1);
        
        for(i=0; i<4; i++) makeWall(180+ 30*i, 450, 1);
        for(i=0; i<7; i++) makeThorn(300+ 30*i, 450, 1);
        for(i=0; i<4; i++) makeWall(510+ 30*i, 450, 1);
        
        makeStar(180, 420);
        for(i=0; i<4; i++) makeWall(230+ 30*i, 240, 1);
        makeElectricity(260, 300);
        makeElectricity(260, 270);
        makeElectricity(290, 300);
        makeElectricity(290, 270);
        
        makeItem2(390, 240);
        for(i=0; i<2; i++) makeBreakable(390, 270+ i*30);
        
        makeStar(600, 420);
        for(i=0; i<4; i++) makeWall(460+ 30*i, 240, 1);
        makeElectricity(490, 300);
        makeElectricity(490, 270);
        makeElectricity(520, 300);
        makeElectricity(520, 270);
        
        for(i=0; i<7; i++) makeWall(180+ 30*i, 90, 1);
        makeItem1(390, 90);
        for(i=0; i<7; i++) makeWall(420+ 30*i, 90, 1);
        for(i=0; i<11; i++) makeWall(630, 120+ 30*i, 1);
  }
}