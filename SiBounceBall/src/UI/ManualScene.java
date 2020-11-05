package UI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import OptimizedSBB.SBBMain;

public class ManualScene {

	private Image manualImage = new ImageIcon(SBBMain.class.getResource("../Image/manual.png")).getImage();
	
	class Manual extends JPanel{
        public void paintComponent(Graphics g){
        	super.paintComponent(g);
            g.drawImage(manualImage, 0, 0, null);
        }
    }
}
