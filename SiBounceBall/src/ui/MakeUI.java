package ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import dao.*;
import dto.*;
import optimizedSBB.SBBMain;
import service.*;

public class MakeUI extends JFrame {
	
	public static JFrame f = new JFrame();

	public static ArrayList<ImageIcon> stageImage = new ArrayList<ImageIcon>();
	public static ArrayList<JButton> stageButton = new ArrayList<JButton>();
	protected Image startBackground = new ImageIcon(SBBMain.class.getResource("../Image/startBackground.jpeg")).getImage();
	protected Image stageBackground = new ImageIcon(SBBMain.class.getResource("../Image/stageBackground.jpeg")).getImage();
	protected Image manualImage = new ImageIcon(SBBMain.class.getResource("../Image/manual.png")).getImage();
	protected JButton startButton = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/start_button1.png")));
	protected JButton manual = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/gamemanual.png")));
	protected JButton signUpButton = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/signUpButton.png")));
	protected JButton loginButton = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/loginButton.png")));
	protected JButton Rar = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/Rar.png")));
	protected JButton Lar = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/Lar.png")));
	protected JButton back = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/back.png")));
	protected JButton initialScreen = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/back.png")));
	
	protected int stageNum=1;
	public static int loginOrSignUp = 0;
	protected static String nickName = new String();
	protected String id = new String();
	protected String pw = new String();
    protected static int i;
    public static JLabel stage = new JLabel();
    
	MyPanel panel = new MyPanel();
    Stage stagePanel = new Stage();
    Manual manualPanel = new Manual();
    JPanel inputPanel = new JPanel();
    JPanel nicknamePanel = new JPanel();
    JPanel idPanel = new JPanel();
    JPanel passwordPanel = new JPanel();
    JTextField nickNameField = new JTextField(10);
    JTextField idField = new JTextField(10);
    JPasswordField pwField = new JPasswordField(10);
    JLabel nickNameText = new JLabel();
    JLabel idText = new JLabel();
    JLabel pwText = new JLabel();
    JButton confirmButton = new JButton("Confirm");

	public MakeUI() {}
	
	public void MakeScene() {
		
		f.setTitle("SibounceBall");
		f.setSize(800, 620);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MakeImage();
		
		stage.setBounds(680, 10, 100, 40);
		stage.setVisible(false);
		stage.setForeground(Color.WHITE);
		stage.setFont(stage.getFont().deriveFont(15.0f));
		f.add(stage);		

		MakeUI test = new Button();
		((Button) test).buttonSet();
		f.setVisible(true);
    }
	
	protected void userInput(Object obj) {
		((Component) obj).addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if(src.getText().length() >= 10) ke.consume();
			}
		});
	}
	
	protected void buttonSet(Object obj) {
		((AbstractButton) obj).setBorderPainted(false);
		((AbstractButton) obj).setContentAreaFilled(false);
		((AbstractButton) obj).setFocusPainted(false);
	}
	
	protected void stageButton(int N) {
		stageButton.get(N).addMouseListener(new MouseAdapter(){
        	@Override
        	public void mousePressed(MouseEvent e) {
        		if(SBBMain.highestLevel + 1 > N) {
        			SBBMain.sceneNum = N+1;
        			SBBMain.f.setVisible(true);
        			f.setVisible(false);
        		}
        	}
        }); 
	}
	
	protected void MakeImage() {
		for(i=0;i<8;i++) {
			stageImage.add(new ImageIcon(SBBMain.class.getResource("../Image/"+String.valueOf(i+1)+".png")));
			stageButton.add(new JButton(stageImage.get(i)));
		}
	}
	
	class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
        	super.paintComponent(g);
            g.drawImage(startBackground, 0, 0, null);
        }
    }
	
	class Stage extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            g.drawImage(stageBackground, 0, 0, null);
            g.setColor(Color.WHITE);
            g.fillRect(175-3, 120-3, 200+6, 150+6);
            g.fillRect(425-3, 120-3, 200+6, 150+6);
            g.fillRect(175-3, 350-3, 200+6, 150+6);
            g.fillRect(425-3, 350-3, 200+6, 150+6);
            g.setFont(new Font("Courier New", Font.BOLD, 40));
            g.drawString(String.format("STAGE"), 340, 70);
            g.setFont(new Font("Courier New", Font.BOLD, 30));
            g.drawString(String.format("Level "+((stageNum-1)*4+1)), 210, 305);
            g.drawString(String.format("Level "+((stageNum-1)*4+2)), 460, 305);
            g.drawString(String.format("Level "+((stageNum-1)*4+3)), 210, 545);
            g.drawString(String.format("Level "+((stageNum-1)*4+4)), 460, 545);
        }
	}
	
	class Manual extends JPanel{
        public void paintComponent(Graphics g){
        	super.paintComponent(g);
            g.drawImage(manualImage, 0, 0, null);
        }
    }
}
