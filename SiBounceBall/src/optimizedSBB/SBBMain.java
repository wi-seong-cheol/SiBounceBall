package optimizedSBB;

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

import dto.JoinDto;
import gamecomponents.*;
import moveengine.MoveEngine;
import scenes.*;
import ui.Animation;
import ui.MakeUI;
import ui.StageFrame;

public class SBBMain
{
	public static int click=0;
	public static final int X = 800;
	public static final int Y = 600;
	public static final double GRAVITY = 1500;
	public static final double DRAG = 0;
	public static final double BOUNCE = 1.0013;
	public static final String TITLE = "SibounceBall";
	public static JFrame f;
	public static Canvas c;
	public static BufferStrategy b;
	public static GraphicsEnvironment ge;
	public static GraphicsDevice gd;
	public static GraphicsConfiguration gc;
	public static BufferedImage buffer;
	public static Graphics graphics;
	public static Graphics2D g2d;
	public static AffineTransform at = new AffineTransform();

	//  private static Canvas c;
	//  private static GraphicsEnvironment ge;
	//  private static GraphicsDevice gd;
	//  private static GraphicsConfiguration gc;
	//  private static BufferedImage buffer;
	//  private static Graphics graphics;
	//  private static Graphics2D g2d;
	//  private static AffineTransform at = new AffineTransform();
	public static MyKeyListener keyListener;
	public static ArrayList<Spawn> living = new ArrayList<Spawn>();
	public static boolean isRunning = true;
	public static int sceneNum = 1;
	public static int login = 0;
	public static int highestLevel = 8;
	public static String id;
	public static boolean isPressed1 = false; // Left
	public static boolean isPressed2 = false; // Right
	public static boolean inventory1 = false;
	public static boolean inventory2 = false;
	private static Thread moveEngine = new MoveEngine();
	private static Thread makeMainScene = new MakeMainScene();

	public static Image sibaball;
	public static Image sibaball2;
	public static ArrayList<Image> background = new ArrayList<Image>();
	public static ArrayList<Image> wallImage = new ArrayList<Image>();
	public static ArrayList<Image> thorn = new ArrayList<Image>();
	public static Image jump;
	public static Image item1;
	public static Image item2;
	public static Image star;
	public static Image breakable;
	public static Image moveL;
	public static Image moveR;
	public static Image electricity;

	public static void main(String[] args)
	{
		// Initialize some things.
		StageFrame stageFrame = new StageFrame();
		Animation animation = new Animation();
		MakeUI makeUI = new MakeUI();
		stageFrame.initializeJFrame();
		makeUI.MakeScene();
		moveEngine.start();
		makeMainScene.start();
		animation.runAnimation();
	}

	//awt패키지     : native OS의 GUI 도움받아 작동(중량 컴포넌트) -> OS에따라 GUI다름
	//swing패키지 : JAVA언어로 이루어짐 (경량 컴포넌트) -> GUI가 어떤 OS에서도 동일. 호환성좋음 J로 시작
	//paint => 랜더링 함수
	//update => AWT 엔진이 윈도우 데미지 입었을 때, 사용하는 paint를 호출하는 메서드
	//repaint => 외부에서 AWT 엔진한테 update(g) 좀 사용하라고 요청하는 메서드
	//패널을 추가했다던가, 버튼을 추가했다던가 하면 repaint를 통해 다시 그려줘서 frame에 표시할 수 있음.
}
