package OptimizedSBB;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.util.Scanner;

import Objects.*;
import Scenes.*;
import dao.UDao;
import dto.JoinDto;

public class SBBMain
{
  private static int click=0;
  public static final int X = 800;
  public static final int Y = 600;
  public static final double GRAVITY = 1500;
  public static final double DRAG = 0;
  public static final double BOUNCE = 1.0013;
  public static final String TITLE = "SibounceBall";
  public static JFrame f;
  private static Canvas c;
  public static BufferStrategy b;
  private static GraphicsEnvironment ge;
  private static GraphicsDevice gd;
  private static GraphicsConfiguration gc;
  private static BufferedImage buffer;
  private static Graphics graphics;
  private static Graphics2D g2d;
  private static AffineTransform at = new AffineTransform();
  public static MyKeyListener keyListener;
  public static ArrayList<Spawn> living = new ArrayList<Spawn>();
  public static boolean isRunning = true;
  public static int sceneNum = 1;
  public static int login = 0;
  public static int higestLevel = 0;
  public static String id;
  public static boolean isPressed1 = false; // Left
  public static boolean isPressed2 = false; // Right
  public static boolean inventory1 = false;
  public static boolean inventory2 = false;
  private static Thread moveEngine = new MoveEngine();
  private static Thread makeMainScene = new MakeMainScene();
  private static JButton menu = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/menu.png")));
  private static JButton back = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/back.png")));
  private static JButton main = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/main.png")));
  private static JButton exit = new JButton(new ImageIcon(SBBMain.class.getResource("../Image/exit.png")));
  
  static Image sibaball;
  static Image sibaball2;
  static ArrayList<Image> background = new ArrayList<Image>();
  static ArrayList<Image> wallImage = new ArrayList<Image>();
  static ArrayList<Image> thorn = new ArrayList<Image>();
  static Image jump;
  static Image item1;
  static Image item2;
  static Image star;
  static Image breakable;
  static Image moveL;
  static Image moveR;
  static Image electricity;
  

  public static void main(String[] args)
  {
    // Initialize some things.
    initializeJFrame();
//	    Scanner sc = new Scanner(System.in);
//	    System.out.print("id : ");
//	    String id = sc.nextLine();
//	    System.out.print("nickname : ");
//	    String nickname = sc.nextLine();
//	    System.out.print("pw : ");
//	    String pw = sc.nextLine();
//	    UDao dao = new UDao();
//	    JoinDto dto = new JoinDto(id, nickname, pw);
//	    int rn = dao.join(dto);
//	    System.out.println("rn : " + rn);
    new MakeUI1();
    //new GameOver();
    moveEngine.start();
    makeMainScene.start();
    runAnimation();
    
  }


  public static void runAnimation()
  {
    // Set up some variables.
    int fps = 0;
    int frames = 0;
    long totalTime = 0;
    long curTime = System.currentTimeMillis();
    long lastTime = curTime;
    // Start the loop.
    while (isRunning) {
    	try {
        // Calculations for FPS.
        lastTime = curTime;
        curTime = System.currentTimeMillis();
        totalTime += curTime - lastTime;
        if (totalTime > 1000) {
          totalTime -= 1000;
          fps = frames;
          frames = 0;
        }
        ++frames;
        // clear back buffer...
        g2d = buffer.createGraphics();
        //g2d.fillRect(0, 0, X, Y);
        if(sceneNum==1 || sceneNum==4 || sceneNum==7) g2d.drawImage(background.get(0), 0,0, null);
        else if(sceneNum==2 || sceneNum==5 || sceneNum==6) g2d.drawImage(background.get(1), 0,0, null);
        else if(sceneNum==3 || sceneNum==8) g2d.drawImage(background.get(2), 0,0, null);
        else g2d.drawImage(background.get(0), 0,0, null);
        
        // Draw entities////////////////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < living.size(); i++) {
          try {
        	  at.translate(living.get(i).getX(), living.get(i).getY());
        	  Spawn s = living.get(i);
              if(s instanceof SpawnBall) { 
            	  //g2d.drawImage(sibaball,(int) (s.getX() ),(int) (s.getY() ), c);
            	  g2d.drawImage(sibaball2,(int) (s.getX() )+4,(int) (s.getY() ), c);
              }
              else if(s instanceof SpawnWall){
            	  g2d.drawImage(wallImage.get(s.num-1),(int) (s.getX() ),(int) (s.getY() ), c);
            	  
              }
              else if(s instanceof SpawnThorn) {
            	  g2d.drawImage(thorn.get(s.num-1),(int) (s.getX() ),(int) (s.getY() ), c);
              }
              else if(s instanceof SpawnJump) {
            	  g2d.drawImage(jump,(int) (s.getX() ),(int) (s.getY() ), c);
              }
              else if(s instanceof SpawnElectricity) {
            	  g2d.drawImage(electricity,(int) (s.getX() ),(int) (s.getY() ), c);
              }
              else if(s instanceof SpawnItem1) {
            	  g2d.drawImage(item1,(int) (s.getX() ),(int) (s.getY() ), c);
              }
              else if(s instanceof SpawnItem2) {
            	  g2d.drawImage(item2,(int) (s.getX() ),(int) (s.getY() ), c);
              }
              else if(s instanceof SpawnStar) {
            	  g2d.drawImage(star,(int) (s.getX() ),(int) (s.getY() ), c);
              }
              else if(s instanceof SpawnBreakable) {
            	  g2d.drawImage(breakable,(int) (s.getX() ),(int) (s.getY() ), c);
              }
              else if(s instanceof SpawnMoveL) {
            	  g2d.drawImage(moveL,(int) (s.getX() ),(int) (s.getY() ), c);
              }
              else if(s instanceof SpawnMoveR) {
            	  g2d.drawImage(moveR,(int) (s.getX() ),(int) (s.getY() ), c);
              }
          }catch (Exception e) {
        	  continue;
          }
          
          
          
          /* <type>
           * Ball
           * Wall
           * Jump
           * Thorn
           * Item1 : 대쉬
           * Item2 : 점프
           * Star
           * Breakable
           * MoveL
           * MoveR
           */    
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        
        // display frames per second...
        g2d.setFont(new Font("Courier New", Font.PLAIN, 12));
        g2d.setColor(Color.GREEN);
        g2d.drawString(String.format("FPS: %s", fps), 20, 20);
        // Blit image and flip...
        graphics = b.getDrawGraphics();
        graphics.drawImage(buffer, 0, 0, null);
        if (!b.contentsLost()) b.show();
        // Let the OS have a little time...
        Thread.sleep(15);
      } catch (InterruptedException e) {
      } finally {
        // release resources
        if (graphics != null) graphics.dispose();
        if (g2d != null) g2d.dispose();
      }
    }
  }

  public static synchronized void makeBall(int x, int y) {
    living.add(new SpawnBall(x, y));
  }
  public static synchronized void makeWall(int x, int y, int n) {
	living.add(new SpawnWall(x, y, n));  
  }
  public static synchronized void makeJump(int x, int y) {
	living.add(new SpawnJump(x, y));  
  }
  public static synchronized void makeThorn(int x, int y, int n) {
	living.add(new SpawnThorn(x, y, n));
  }
  public static synchronized void makeElectricity(int x, int y) {
	living.add(new SpawnElectricity(x, y));
  }
  public static synchronized void makeItem1(int x, int y) {
	living.add(new SpawnItem1(x, y));
  }
  public static synchronized void makeItem2(int x, int y) {
	living.add(new SpawnItem2(x, y));
  }
  public static synchronized void makeStar(int x, int y) {
	living.add(new SpawnStar(x, y));
  }
  public static synchronized void makeBreakable(int x, int y) {
	living.add(new SpawnBreakable(x, y));
  }
  public static synchronized void makeMoveL(int x, int y) {
	living.add(new SpawnMoveL(x, y));
  }
  public static synchronized void makeMoveR(int x, int y) {
	living.add(new SpawnMoveR(x, y));
  }
  

  //awt패키지     : native OS의 GUI 도움받아 작동(중량 컴포넌트) -> OS에따라 GUI다름
  //swing패키지 : JAVA언어로 이루어짐 (경량 컴포넌트) -> GUI가 어떤 OS에서도 동일. 호환성좋음 J로 시작
  //paint => 랜더링 함수
  //update => AWT 엔진이 윈도우 데미지 입었을 때, 사용하는 paint를 호출하는 메서드
  //repaint => 외부에서 AWT 엔진한테 update(g) 좀 사용하라고 요청하는 메서드
  //패널을 추가했다던가, 버튼을 추가했다던가 하면 repaint를 통해 다시 그려줘서 frame에 표시할 수 있음.
  
  private static void setImages()
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

  private static void initializeJFrame()
  {
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
	
	main.setBounds(275, 80, 50, 50);
	main.addMouseListener(new MouseAdapter(){
    	@Override
    	public void mousePressed(MouseEvent e) {
    		f.setFocusable(true);
    		back.setFocusable(false);
    		MakeUI1.f.setVisible(true);
    		MakeUI1.stage.setText("Clear Level " + SBBMain.higestLevel);
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
    setImages();
  }
}