package UI;

import java.awt.Image;

import javax.swing.ImageIcon;

import OptimizedSBB.SBBMain;

public class ImageSet extends SBBMain {
	public ImageSet() {};
	public static void setImages()
	{
		sibaball = new ImageIcon(SBBMain.class.getResource("../Image/sibaball.png")).getImage();
		sibaball2 = new ImageIcon(SBBMain.class.getResource("../Image/sibaball2.png")).getImage();
		background.add(new ImageIcon(SBBMain.class.getResource("../Image/background1.png")).getImage());
		background.add(new ImageIcon(SBBMain.class.getResource("../Image/background2.png")).getImage()); 
		background.add(new ImageIcon(SBBMain.class.getResource("../Image/background3.jpg")).getImage()); 
		wallImage.add(new ImageIcon(SBBMain.class.getResource("../Image/wall1.png")).getImage());
		wallImage.add(new ImageIcon(SBBMain.class.getResource("../Image/wall2.png")).getImage());
		wallImage.add(new ImageIcon(SBBMain.class.getResource("../Image/wall3.png")).getImage());
		wallImage.add(new ImageIcon(SBBMain.class.getResource("../Image/wall4.png")).getImage());
		wallImage.add(new ImageIcon(SBBMain.class.getResource("../Image/wall5.png")).getImage());
		thorn.add(new ImageIcon(SBBMain.class.getResource("../Image/thorn1.png")).getImage());
		thorn.add(new ImageIcon(SBBMain.class.getResource("../Image/thorn2.png")).getImage());
		thorn.add(new ImageIcon(SBBMain.class.getResource("../Image/thorn3.png")).getImage());
		thorn.add(new ImageIcon(SBBMain.class.getResource("../Image/thorn4.png")).getImage());
		jump = new ImageIcon(SBBMain.class.getResource("../Image/jump.png")).getImage();
		electricity = new ImageIcon(SBBMain.class.getResource("../Image/electricity.png")).getImage();
		item1 = new ImageIcon(SBBMain.class.getResource("../Image/item1.png")).getImage();
		item2 = new ImageIcon(SBBMain.class.getResource("../Image/item2.png")).getImage();
		star = new ImageIcon(SBBMain.class.getResource("../Image/star.png")).getImage();
		breakable = new ImageIcon(SBBMain.class.getResource("../Image/breakable.png")).getImage();
		moveL = new ImageIcon(SBBMain.class.getResource("../Image/moveL.png")).getImage();
		moveR = new ImageIcon(SBBMain.class.getResource("../Image/moveR.png")).getImage();
	}
}
