package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import OptimizedSBB.SBBMain;
import dao.*;
import dto.*;
import service.*;

public class MakeUI extends JFrame {
	public static JFrame f = new JFrame();

	private ArrayList<ImageIcon> stageImage = new ArrayList<ImageIcon>();
	private ArrayList<JButton> stageButton = new ArrayList<JButton>();
	private Image startBackground = new ImageIcon(SBBMain.class.getResource("../Image/startBackground.jpeg")).getImage();
	private Image stageBackground = new ImageIcon(SBBMain.class.getResource("../Image/stageBackground.jpeg")).getImage();
	private Image manualImage = new ImageIcon(SBBMain.class.getResource("../Image/manual.png")).getImage();
	private JButton startButton = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/start_button1.png")));
	private JButton manual = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/gamemanual.png")));
	private JButton signUpButton = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/signUpButton.png")));
	private JButton loginButton = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/loginButton.png")));
	private JButton Rar = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/Rar.png")));
	private JButton Lar = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/Lar.png")));
	private JButton back = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/back.png")));
	private JButton initialScreen = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/back.png")));
	
	private int stageNum=1;
	private int loginOrSignUp = 0;
	private String nickName = new String();
	private String id = new String();
	private String pw = new String();
    private static int i;
    public static JLabel stage = new JLabel();
    
	public MakeUI(){
		
		MakeImage();
		f.setTitle("SibounceBall");
		f.setSize(800, 620);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
       
        UserService user = new UserService();
        confirmButton.setBounds(355, 135, 90, 30);
        confirmButton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		signUpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		System.out.println(loginOrSignUp);
        		if(loginOrSignUp == 1) {
            		loginButton.setVisible(true);
            		signUpButton.setVisible(true);
            		inputPanel.setVisible(false);
            		initialScreen.setVisible(false);
            		
            		nickName = nickNameField.getText();
            		id = idField.getText();
            		pw = pwField.getText();
//            		UDao dao = new UDao();
//            	    JoinDto dto = new JoinDto(nickName, id, pw);
//            	    int rn = dao.join(dto);
            		//textField 초기화 
            		nickNameField.setText(null);
            		idField.setText(null);
            		pwField.setText(null);
        		}
        		else {
            		id = idField.getText();
            		SBBMain.id = id;
            		pw = pwField.getText();
//            		UDao dao = new UDao();
//            	    LoginDto dto = new LoginDto(id, pw);
//            	    int rn = user.login(dto);
            		int rn = 1;

        			SBBMain.login = rn;
            	    nickNameField.setText(null);
            		idField.setText(null);
            		pwField.setText(null);
            		if(rn == 1) {
//            			SBBMain.higestLevel = user.getHighestLevel(id);
            			startButton.setVisible(true);
            			manual.setVisible(true);
            			inputPanel.setVisible(false);
                		initialScreen.setVisible(false);
                		stage.setText("Clear Level " + SBBMain.highestLevel);
            		}
        		}
        	}
        });
		
        signUpButton.setBounds(264, 70, 126, 52);
        signUpButton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		signUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		signUpButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		System.out.println("sign up");
        		loginButton.setVisible(false);
        		signUpButton.setVisible(false);
        		inputPanel.setVisible(true);
        		loginOrSignUp = 1;
        		initialScreen.setVisible(true);
        	}
        });
		buttonSet(signUpButton);
		f.add(signUpButton);		

		loginButton.setBounds(410, 70, 126, 52);
        loginButton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		loginButton.setVisible(false);
        		signUpButton.setVisible(false);
        		nicknamePanel.setVisible(false);
        		inputPanel.setVisible(true);
        		loginOrSignUp = 2;
        		initialScreen.setVisible(true);
        	}
        });
		buttonSet(loginButton);
		f.add(loginButton);
		
		nickNameField.setBounds(350, 35, 150, 30);
		userInput(nickNameField);
		nickNameText.setText("Nickname");
		nickNameText.setBounds(282, 35, 150, 30);
		nicknamePanel.setBackground(new Color(246, 200, 167));
		nicknamePanel.add(nickNameText);
		nicknamePanel.add(nickNameField);
		
		idField.setBounds(350, 70, 150, 30);
		userInput(idField);
		idText.setText("ID");
		idText.setBounds(305, 70, 150, 30);
		idPanel.setBackground(new Color(246, 200, 167));
		idPanel.add(idText);
		idPanel.add(idField);
		
		pwField.setBounds(350, 30, 150, 30);
		userInput(pwField);
		pwText.setText("Password");
		pwText.setBounds(282, 105, 150, 30);
		passwordPanel.setBackground(new Color(246, 200, 167));
		passwordPanel.add(pwText);
		passwordPanel.add(pwField);
		
		// input Panel
		inputPanel.setSize(220, 150);
		inputPanel.setLocation(282,20);
		inputPanel.add(nicknamePanel);
		inputPanel.add(idPanel);
		inputPanel.add(passwordPanel);
        inputPanel.add(confirmButton);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(-10 , -10 , 0, 0));
		inputPanel.setVisible(false);
		inputPanel.setBackground(new Color(246, 200, 167));
		f.add(inputPanel);
		
		stage.setBounds(680, 10, 100, 40);
		stage.setVisible(false);
		stage.setForeground(Color.WHITE);
		stage.setFont(stage.getFont().deriveFont(15.0f));
		f.add(stage);
        
        startButton.setBounds(330, 80, 119, 49);
        startButton.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		//게임 시작 이벤트 
        		System.out.println("1");
        		startButton.setVisible(false);
        		back.setVisible(true);
        		manual.setVisible(false);
        		panel.setVisible(false);
        		Rar.setVisible(true);
        		stage.setVisible(true);
        		f.add(stagePanel);
        		stagePanel.setVisible(true);
        		stage.setText("Clear Level " + SBBMain.highestLevel);
            	stage.setVisible(true);
        		for(int i=0;i<4;i++) {
        			stageButton.get(i).setVisible(true);
        		}
        	}
        });
		buttonSet(startButton);
		if(SBBMain.login == 0)
			startButton.setVisible(false);
		f.add(startButton);
		
		manual.setBounds(650, 515, 137, 62);
        manual.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mousePressed(MouseEvent e) {
        		startButton.setVisible(false);
        		manual.setVisible(false);
        		back.setVisible(true);
        		panel.setVisible(false);
        		manualPanel.setVisible(true);
        		f.add(manualPanel);

        	}
        });
		buttonSet(manual);
		manual.setVisible(false);
		f.add(manual);
        
        initialScreen.setBounds(10, 10, 50, 50);
        initialScreen.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mousePressed(MouseEvent e) {
        		panel.setVisible(true);
        		stagePanel.setVisible(false);
        		for(int i=0;i<8;i++) {
        			stageButton.get(i).setVisible(false);
        		}
        		loginButton.setVisible(true);
        		signUpButton.setVisible(true);
        		inputPanel.setVisible(false);
        		nicknamePanel.setVisible(true);
        		nickNameField.setText(null);
        		idField.setText(null);
        		pwField.setText(null);
        		initialScreen.setVisible(false);       		
        	}
        });
		buttonSet(initialScreen);
		f.setFocusable(true);
		f.add(initialScreen);
		initialScreen.setVisible(false);
        
		back.setBounds(10, 10, 50, 50);
		back.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mousePressed(MouseEvent e) {
        		panel.setVisible(true);
        		stagePanel.setVisible(false);
        		for(int i=0;i<8;i++) {
        			stageButton.get(i).setVisible(false);
        		}
        		Lar.setVisible(false);
        		Rar.setVisible(false);
        		manual.setVisible(true);
        		back.setVisible(false);
        		startButton.setVisible(true);
        		stage.setVisible(false);
        		stagePanel.setVisible(false);
        		manualPanel.setVisible(false);
        	}
        });
		buttonSet(back);
		f.setFocusable(true);
		f.add(back);
		back.setVisible(false);
		
		Lar.setBounds(37, 500, 41, 45);
		Lar.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		Lar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		Lar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		stageNum=1;
        		switch(stageNum) {
        			case 1:
        				for(int i=0;i<4;i++) {
                			stageButton.get(i).setVisible(true);
                		}
        				for(int i=4;i<8;i++) {
                			stageButton.get(i).setVisible(false);
                		}
        				Lar.setVisible(false);
        				Rar.setVisible(true);
        				
        				break;
        			case 2:
        				break;
        			default :
        				System.out.println("stageNum Error : ");
        				break;
        		}	
        	}
        });
		buttonSet(Lar);
		f.add(Lar);
		Lar.setVisible(false);
		
		Rar.setBounds(724, 500, 39, 45);
		Rar.addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		Rar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		Rar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		stageNum=2;
        		switch(stageNum) {
	    			case 1:
	    				break;
	    			case 2:
	    				for(int i=4;i<8;i++) {
	            			stageButton.get(i).setVisible(true);
	            		}
	    				for(int i=0;i<4;i++) {
	            			stageButton.get(i).setVisible(false);
	            		}
	    				Rar.setVisible(false);
	    				Lar.setVisible(true);
	    				break;
	    			default :
	    				System.out.println("stageNum Error : ");
	    				break;
	    		}	
        	}
        });
		buttonSet(Rar);
		f.add(Rar);
		Rar.setVisible(false);
		
		for(i=0;i<8;i++) {
			switch(i%4) {
				case 0:
					stageButton.get(i).setBounds(175, 120, 200, 150);
					break;
				case 1:
					stageButton.get(i).setBounds(425, 120, 200, 150);
					break;
				case 2:
					stageButton.get(i).setBounds(175, 350, 200, 150);
					break;
				case 3:
					stageButton.get(i).setBounds(425, 350, 200, 150);
					break;
				default :
					System.out.println("Error : ");
					break;
			}
			f.add(stageButton.get(i));
			stageButton.get(i).setVisible(false);
			stageButton(i);
		}
		f.add(panel);
		f.setVisible(true);
    }
	private void userInput(Object obj) {
		((Component) obj).addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if(src.getText().length() >= 10) ke.consume();
			}
		});
	}
	private void buttonSet(Object obj) {
		((AbstractButton) obj).setBorderPainted(false);
		((AbstractButton) obj).setContentAreaFilled(false);
		((AbstractButton) obj).setFocusPainted(false);
	}
	private void stageButton(int N) {
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
	private void MakeImage() {
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