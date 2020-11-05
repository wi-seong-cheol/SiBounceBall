package UI;

import javax.swing.JFrame;

public class UIController {
	
	public static JFrame f = new JFrame();
	
	public void makeFrame() {
		f.setTitle("SibounceBall");
		f.setSize(800, 620);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		changeScene();
	}
	
	public void changeScene() {
		
	}
}
