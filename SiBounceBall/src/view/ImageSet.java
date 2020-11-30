package view;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import optimizedSBB.SBBMain;

public class ImageSet extends SBBMain {
	public ImageSet() {};
	
	public static Image sibaball;
	public static Image sibaball2;
	
	public static ArrayList<Image> background = new ArrayList<Image>();	
	public static ArrayList<Image> wallImage = new ArrayList<Image>();	
	public static ArrayList<Image> thorn = new ArrayList<Image>();	
	
	public static Image jump;
	public static Image electricity;
	public static Image dashItem;
	public static Image jumpItem;
	public static Image star;
	public static Image breakable;
	public static Image moveL;
	public static Image moveR;
	
	private static final int backgrounds = 3;
	private static final int wallImages = 5;
	private static final int thorns = 4;
	
    protected static int i;	
	
	public static void setImages()	{
		
		getImageBall();
		getImageBack();
		getImageWall();
		getImageThorn();
		getImageObject();
		
	}
	
	public static void getImageBall() {
		sibaball = new ImageIcon(SBBMain.class.getResource("../Image/sibaball2.png")).getImage();
	}
	
	public static void getImageBack() {
		for(i = 1; i <= backgrounds - 1; i++) 
			background.add(new ImageIcon(SBBMain.class.getResource("../Image/background" + String.valueOf(i) + ".png")).getImage());	
		background.add(new ImageIcon(SBBMain.class.getResource("../Image/background3.jpg")).getImage());
	}
	
	
	public static void getImageWall() {
		for(i = 1; i <= wallImages; i++)
			wallImage.add(new ImageIcon(SBBMain.class.getResource("../Image/wall" + String.valueOf(i) + ".png")).getImage());		
	}
	
	
	public static void getImageThorn() {
		for(i = 1; i <= thorns; i++) 
			thorn.add(new ImageIcon(SBBMain.class.getResource("../Image/thorn" + String.valueOf(i) + ".png")).getImage());
	}
	
	public static void getImageObject() {
		jump        = new ImageIcon(SBBMain.class.getResource("../Image/jump.png")).getImage();
		electricity = new ImageIcon(SBBMain.class.getResource("../Image/electricity.png")).getImage();
		dashItem    = new ImageIcon(SBBMain.class.getResource("../Image/item1.png")).getImage();
		jumpItem    = new ImageIcon(SBBMain.class.getResource("../Image/item2.png")).getImage();
		star        = new ImageIcon(SBBMain.class.getResource("../Image/star.png")).getImage();
		breakable   = new ImageIcon(SBBMain.class.getResource("../Image/breakable.png")).getImage();
		moveL       = new ImageIcon(SBBMain.class.getResource("../Image/moveL.png")).getImage();
		moveR       = new ImageIcon(SBBMain.class.getResource("../Image/moveR.png")).getImage();
	}

}
