package UI;

import java.awt.Canvas;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import OptimizedSBB.MyKeyListener;
import OptimizedSBB.SBBMain;

public class StageFrame extends SBBMain {
	private static JButton menu = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/menu.png")));
	private static JButton back = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/back.png")));
	private static JButton main = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/main.png")));
	private static JButton exit = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/exit.png")));
	
	public StageFrame() { }
	public void initializeJFrame()	{
		// Create the frame...
		f = new JFrame(TITLE); // 프레임

		keyListener = new MyKeyListener();

		f.addKeyListener(keyListener);
		f.setIgnoreRepaint(false); // 더블버퍼 관련, repaint()를 막는 메소드
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 화면종료시 어플리케이션 종료시킴. (Console에서 작동종료.)
		// Create canvas for painting...
		c = new Canvas(); // 화면
		// 캔버스를 새로 만드는거.
		c.setIgnoreRepaint(true);
		c.setSize(X, Y);

		menuButtonSet();
		mainButtonSet();
		exitButtonSet();
		backButtonSet();

		// Set up the BufferStrategy for double buffering.
		c.createBufferStrategy(2);
		b = c.getBufferStrategy();
		// Get graphics configuration...(그래픽 환경)
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();
		// Create off-screen drawing surface
		buffer = gc.createCompatibleImage(X, Y);
		// Objects needed for rendering...
		graphics = null;
		g2d = null;
		ImageSet.setImages();
	}
	
	private void menuButtonSet() {
		menu.setBounds(735, 10, 50, 50);
		menu.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				f.setFocusable(false);
				back.setFocusable(true);
				click=1;
				main.setVisible(true);
				exit.setVisible(true);
				back.setVisible(true);
				menu.setVisible(false);
			}
		});
		menu.setBorderPainted(false);
		menu.setContentAreaFilled(false);
		menu.setFocusPainted(false);
		f.add(menu);
	}
	
	private void mainButtonSet() {
		main.setBounds(275, 80, 50, 50);
		main.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				f.setFocusable(true);
				back.setFocusable(false);
				MakeUI.f.setVisible(true);
				MakeUI.stage.setText("Clear Level " + SBBMain.highestLevel);
				main.setVisible(false);
				exit.setVisible(false);
				back.setVisible(false);
				menu.setVisible(true);
				f.setVisible(false);
				sceneNum=0;
			}
		});
		main.setContentAreaFilled(false);
		main.setFocusPainted(false);
		f.add(main);
		main.setVisible(false);
	}
	
	private void exitButtonSet() {
		exit.setBounds(475, 80, 50, 50);
		exit.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
		f.add(exit);
		exit.setVisible(false);
	}
	
	private void backButtonSet() {
		back.setBounds(375, 80, 50, 50);
		back.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				f.setFocusable(true);
				back.setFocusable(false);
				click=0;
				main.setVisible(false);
				exit.setVisible(false);
				back.setVisible(false);
				menu.setVisible(true);
			}
		});
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		f.add(back);
		back.setVisible(false);
		f.setFocusable(true);
		// Add the canvas, and display.
		f.add(c);
		f.pack(); // 창크기 Canvas에 맞게 해줌
		f.setLocationRelativeTo(null); // 실행시 window frame을 screen 중앙으로
		f.setVisible(false);
	}
}
