package Scenes;

import OptimizedSBB.SBBMain;

public class MakeScene9
{
   int i;
   public void makeScene()
   {
      MakeMainScene.star = 4;
        SBBMain.makeBall(320, 150);
        SBBMain.makeItem1(150, 900);
        for(i=0; i<11; i++) SBBMain.makeWall(150, 120+ 30*i, 1);
        SBBMain.makeWall(180, 420, 4);
        
        for(i=0; i<2; i++) SBBMain.makeWall(240+ 30*i, 450, 1);
        for(i=0; i<7; i++) SBBMain.makeWall(300+ 30*i, 450, 1);
        for(i=0; i<2; i++) SBBMain.makeWall(510+ 30*i, 450, 1);
        
        SBBMain.makeMoveL(360, 420);
        SBBMain.makeMoveR(390, 420);
        
        SBBMain.makeStar(180, 390);
        for(i=0; i<4; i++) SBBMain.makeWall(230+ 30*i, 240, 1);
        SBBMain.makeElectricity(260, 300);
        SBBMain.makeElectricity(260, 270);
        SBBMain.makeElectricity(290, 300);
        SBBMain.makeElectricity(290, 270);
        
        SBBMain.makeItem2(390, 240);
        for(i=0; i<2; i++) SBBMain.makeBreakable(390, 270+ i*30);
        
        SBBMain.makeStar(600, 390);
        for(i=0; i<4; i++) SBBMain.makeWall(460+ 30*i, 240, 1);
        SBBMain.makeElectricity(490, 300);
        SBBMain.makeElectricity(490, 270);
        SBBMain.makeElectricity(520, 300);
        SBBMain.makeElectricity(520, 270);
        
        for(i=0; i<7; i++) SBBMain.makeWall(180+ 30*i, 90, 1);
        SBBMain.makeItem1(390, 90);
        for(i=0; i<7; i++) SBBMain.makeWall(420+ 30*i, 90, 1);
        
        SBBMain.makeWall(600, 420, 4);
        for(i=0; i<11; i++) SBBMain.makeWall(630, 120+ 30*i, 1);
  }
}