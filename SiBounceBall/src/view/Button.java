package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;

import viewModel.Information;
import viewModel.UserInput;
//import service.UserService;

class Button extends MakeUI {

	Information info = new Information();
	
	public Button() {} 

	public void buttonSet() {
		backButtonSet();
        confirmButtonSet();
		signUpButtonSet();
		loginButtonSet();
		textFieldSet();
		inputPanelSet();
		startButtonSet();
		manualButtonSet();
		initialScreenButtonSet();
		stageButtonSet();
		arrowButtonSet();
		
		f.add(panel);
	}
	
	private void initialScreenButtonSet() {
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
        		initialScreen.setVisible(false); 
        		textFieldInit();
        	}
        });
		buttonSet(initialScreen);
		f.setFocusable(true);
		f.add(initialScreen);
		initialScreen.setVisible(false);
	}
	
	private void textFieldInit() {
		nickNameField.setText(null);
		idField.setText(null);
		pwField.setText(null);
	}
	
	private void confirmButtonSet() {

//        UserService user = new UserService();
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
        		UserInput inputViewModel = new UserInput();
        		if(Information.getLoginOrSignUp() == 1) {
        			loginButton.setVisible(true);
        			signUpButton.setVisible(true);
            		inputPanel.setVisible(false);
            		initialScreen.setVisible(false);
            		inputViewModel.signUpInput();
//            		UDao dao = new UDao();
//            	    JoinDto dto = new JoinDto(nickName, id, pw);
//            	    int rn = dao.join(dto);
            		textFieldInit();
        		}
        		else {
            		inputViewModel.loginInput();
            		inputViewModel.login();
//            		UDao dao = new UDao();
//            	    LoginDto dto = new LoginDto(id, pw);
//            	    int rn = user.login(dto);
            		int rn = 1;

            		info.setLogin(rn);;
            		textFieldInit();
            		if(rn == 1) {
//            			SBBMain.higestLevel = user.getHighestLevel(id);
            			startButton.setVisible(true);
            			manual.setVisible(true);
            			inputPanel.setVisible(false);
                		initialScreen.setVisible(false);
                		stage.setText("Clear Level " + Information.getHighLevel());
            		}
        		}
        	}
        });
	}
	
	private void signUpButtonSet() {
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
        		info.setLoginOrSignUp(1);
        		initialScreen.setVisible(true);
        	}
        });
		buttonSet(signUpButton);
		f.add(signUpButton);	
	}
	
	private void loginButtonSet() {
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
        		System.out.println("login");
        		loginButton.setVisible(false);
        		signUpButton.setVisible(false);
        		nicknamePanel.setVisible(false);
        		inputPanel.setVisible(true);
        		info.setLoginOrSignUp(2);
        		initialScreen.setVisible(true);
        	}
        });
		buttonSet(loginButton);
		f.add(loginButton);
	}
	
	private void textFieldSet() {
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
	}
	
	private void inputPanelSet() {
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
	}
	
	private void startButtonSet() {
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
        		stage.setText("Clear Level " + Information.getHighLevel());
            	stage.setVisible(true);
        		for(int i=0;i<4;i++) {
        			stageButton.get(i).setVisible(true);
        		}
        	}
        });
		buttonSet(startButton);
		if(Information.getLogin() == 0)
			startButton.setVisible(false);
		f.add(startButton);
	}
	
	private void manualButtonSet() {
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
	}
	
	private void backButtonSet() {
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
	}
	
	private void stageButtonSet() {
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
	
	private void arrowButtonSet() {
		Lar.setBounds(37, 500, 41, 45);
		arrowButtonSet(Lar,Rar);
		Rar.setBounds(724, 500, 39, 45);
		arrowButtonSet(Rar,Lar);
	}
	
	private void arrowButtonSet(Object arrow1, Object arrow2) {
		((AbstractButton) arrow1).addMouseListener(new MouseAdapter(){
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		((AbstractButton) arrow1).setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        	@Override
        	public void mouseExited(MouseEvent e) {
        		((AbstractButton) arrow1).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		if(arrow1 == Lar) {
        			stageNum = 1;
    				for(int i=4;i<8;i++) {
            			stageButton.get(i).setVisible(false);
            		}
    				for(int i=0;i<4;i++) {
            			stageButton.get(i).setVisible(true);
            		}
    				Lar.setVisible(false);
    				Rar.setVisible(true);
				}
        		if(arrow1 == Rar) {
        			stageNum = 2;
    				for(int i=4;i<8;i++) {
            			stageButton.get(i).setVisible(true);
            		}
    				for(int i=0;i<4;i++) {
            			stageButton.get(i).setVisible(false);
            		}
    				Rar.setVisible(false);
    				Lar.setVisible(true);
				}	
        	}
        });
		buttonSet((AbstractButton) arrow1);
		f.add((AbstractButton) arrow1);
		((AbstractButton) arrow1).setVisible(false);
	}
}
