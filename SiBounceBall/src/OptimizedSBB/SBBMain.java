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



import Objects.*;
import Scenes.*;


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


    //new MakeUI1();

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
           * Item1 : 占쏙옙占쎈룴
           * Item2 : 占쎌젎占쎈늄
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
  

  //awt占쎈솭占쎄텕筌욑옙     : native OS占쎌벥 GUI 占쎈즲占쏙옙獄쏆룇釉� 占쎌삂占쎈짗(餓λ쵎�쎗 �뚮똾猷뤄옙瑗놂옙�뱜) -> OS占쎈퓠占쎈뎡占쎌뵬 GUI占쎈뼄�뵳占�
  //swing占쎈솭占쎄텕筌욑옙 : JAVA占쎈섧占쎈선嚥∽옙 占쎌뵠�뙴�뫁堉깍쭪占� (野껋럥�쎗 �뚮똾猷뤄옙瑗놂옙�뱜) -> GUI揶쏉옙 占쎈선占쎈샥 OS占쎈퓠占쎄퐣占쎈즲 占쎈짗占쎌뵬. 占쎌깈占쎌넎占쎄쉐�넫�뿭�벉 J嚥∽옙 占쎈뻻占쎌삂
  //paint => 占쎌삏占쎈쐭筌랃옙 占쎈맙占쎈땾
  //update => AWT 占쎈퓦筌욊쑴�뵠 占쎌맊占쎈즲占쎌뒭 占쎈쑓沃섎챷占� 占쎌뿯占쎈�占쎌뱽 占쎈르, 占쎄텢占쎌뒠占쎈릭占쎈뮉 paint�몴占� 占쎌깈�빊�뮉釉�占쎈뮉 筌롫뗄苑뚳옙諭�
  //repaint => 占쎌뇚�겫占쏙옙肉됵옙苑� AWT 占쎈퓦筌욊쑵釉놂옙�� update(g) �넫占� 占쎄텢占쎌뒠占쎈릭占쎌뵬�⑨옙 占쎌뒄筌ｏ옙占쎈릭占쎈뮉 筌롫뗄苑뚳옙諭�
  //占쎈솭占쎄섯占쎌뱽 �빊遺쏙옙占쎈뻥占쎈뼄占쎈쐲揶쏉옙, 甕곌쑵�뱣占쎌뱽 �빊遺쏙옙占쎈뻥占쎈뼄占쎈쐲揶쏉옙 占쎈릭筌롳옙 repaint�몴占� 占쎈꽰占쎈퉸 占쎈뼄占쎈뻻 域밸챶�젻餓μ꼷苑� frame占쎈퓠 占쎈ご占쎈뻻占쎈막 占쎈땾 占쎌뿳占쎌벉.
  
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
    f = new JFrame(TITLE); // 占쎈늄占쎌쟿占쎌뿫
    
    keyListener = new MyKeyListener();
    
    f.addKeyListener(keyListener);
    f.setIgnoreRepaint(false); // 占쎈쐭�뇡遺얠쒔占쎈쓠 �꽴占쏙옙�졃, repaint()�몴占� 筌띾맧�뮉 筌롫뗄�꺖占쎈굡
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 占쎌넅筌롫똻伊뚨뙴�슣�뻻 占쎈선占쎈탣�뵳�딉옙占쎌뵠占쎈�� �넫�굝利븝옙�뻻占쎄땀. (Console占쎈퓠占쎄퐣 占쎌삂占쎈짗�넫�굝利�.)
    // Create canvas for painting...
    c = new Canvas(); // 占쎌넅筌롳옙
    // 筌�遺얠쒔占쎈뮞�몴占� 占쎄퉱嚥∽옙 筌띾슢諭띰옙�뮉椰꾬옙.
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
    		//MakeUI.f.setVisible(true);
    		//MakeUI.stage.setText("Clear Level " + SBBMain.highestLevel);
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
	f.pack(); // 筌≪�寃뺞묾占� Canvas占쎈퓠 筌띿쉳苡� 占쎈퉸餓ο옙
	f.setLocationRelativeTo(null); // 占쎈뼄占쎈뻬占쎈뻻 window frame占쎌뱽 screen 餓λ쵐釉곤옙�몵嚥∽옙
	f.setVisible(false);

	// Set up the BufferStrategy for double buffering.
	c.createBufferStrategy(2);
	b = c.getBufferStrategy();
	// Get graphics configuration...(域밸챶�삋占쎈동 占쎌넎野껓옙)
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
