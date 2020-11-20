package OptimizedSBB;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import gamecomponents.*;
import scenes.MakeGameComponents;
import scenes.MakeMainScene;

public class CollideStrategyPattern {
	public SpawnBall ball;
	public Spawn object;
	public int collideObjIdx;
	public double collidePos;
	public ArrayList<Accel> constForces;
	public CollideObject cObject;
	
	public CollideStrategyPattern(SpawnBall ball, Spawn object, int collideObjIdx, ArrayList<Accel> constForces) {
		this.ball = ball;
		this.object = object;
		this.collideObjIdx = collideObjIdx;
		this.constForces = constForces;
		setCollideObject();
	}
	public void setCollidePos(double collidePos) {
		this.collidePos = collidePos;
	}
	public void setCollideObject() {
		if(object instanceof SpawnWall) {
			cObject = new Wall();
		}
		else if(object instanceof SpawnJump) {
			cObject = new JumpBlock();
		}
		else if(object instanceof SpawnThorn) {
			cObject = new Thorn();
		}
		else if(object instanceof SpawnElectricity) {
			cObject = new Electricity();
		}
		else if(object instanceof SpawnDashItem) {
			cObject = new Item1();
		}
		else if(object instanceof SpawnJumpItem) {
			cObject = new Item2();
		}
		else if(object instanceof SpawnStar) {
			cObject = new Star();
		}
		else if(object instanceof SpawnBreakable) {
			cObject = new BreakableBlock();
		}
		else if(object instanceof SpawnMoveL) {
			cObject = new HorizontalMoveL();
		}
		else if(object instanceof SpawnMoveR) {
			cObject = new HorizontalMoveR();
		}
	}
	
	public abstract class CollideObject{
		protected TopSideCollideStrategy topCollide;
		protected BottomSideCollideStrategy bottomCollide;
		protected LeftSideCollideStrategy leftCollide;
		protected RightSideCollideStrategy rightCollide;
		protected AllSideCollideStrategy allCollide;
		
		public synchronized void RegularJumpApply() {
			bottomCollide = new BsRegularJumpStrategy();
			leftCollide = new LsRegularJumpStrategy();
			rightCollide = new RsRegularJumpStrategy();
		}
		
		public synchronized void topCollideHandling() {
			topCollide.topCollideHandler();
		}
		public synchronized void leftCollideHandling() {
			leftCollide.leftCollideHandler();
		}
		public synchronized void rightCollideHandling() {
			rightCollide.rightCollideHandler();
		}
		public synchronized void bottomCollideHandling() {
			bottomCollide.bottomCollideHandler();
		}
		public synchronized void allCollideHandling() {
			allCollide.allCollideHandler();
		}
	}
	
	public class Wall extends CollideObject{
		public Wall() {
			topCollide = new TsRegularJumpStrategy();
			RegularJumpApply();
		}
	}
	public class BreakableBlock extends CollideObject{
		public BreakableBlock() {
			topCollide = new TsBreakableJumpStrategy();
			RegularJumpApply();
		}
	}
	public class JumpBlock extends CollideObject{
		public JumpBlock() {
			topCollide = new TsBlockJumpStrategy();
			RegularJumpApply();
		}
	}
	public class HorizontalMoveL extends CollideObject{
		public HorizontalMoveL() {
			topCollide = new TsLeftMoveStrategy();
			RegularJumpApply();
		}
	}
	public class HorizontalMoveR extends CollideObject{
		public HorizontalMoveR() {
			topCollide = new TsRightMoveStrategy();
			RegularJumpApply();
		}
	}
	public class Thorn extends CollideObject{
		public Thorn() {
			topCollide = new TsResetStrategy();
			RegularJumpApply();
		}
	}
	public class Electricity extends CollideObject{
		public Electricity() {
			allCollide = new ElectricityCollideStrategy();
		}
	}
	public class Item1 extends CollideObject{
		public Item1() {
			allCollide = new GetItem1Strategy();
		}
	}
	public class Item2 extends CollideObject{
		public Item2() {
			allCollide = new GetItem2Strategy();
		}
	}
	public class Star extends CollideObject{
		public Star() {
			allCollide = new GetStarStrategy();
		}
	}
	
	//전략의 메소드 화
	public synchronized void resetGame() {
		ball.updatePos(-150, 500);
		try {
			Thread.sleep(750);
		} catch (Exception e) {}
		ball.updatePos(ball.startX, ball.startY);
		ball.updateVelocity(0, 0);
		SBBMain.sceneNum = -1;
	}
	
	public synchronized void deleteObject() {
		MakeGameComponents.living.remove(collideObjIdx);
	}
	
	//상단 충돌 전략
	//1. 게임 리셋(가시), 2. 일반 점프(일반 블럭), 3. 일반 점프 후 블럭 삭제(일회성 블럭), 4. 좌우 이동(이동 블럭)
	interface TopSideCollideStrategy{
		public void topCollideHandler();
	}
	
	public class TsResetStrategy implements TopSideCollideStrategy{
		public synchronized void topCollideHandler() {
			resetGame();
		}
	}
	
	public synchronized void TsJump(int weight) {
		ball.updatePos(ball.getX(), collidePos);
		ball.updateVelocity(ball.vx(), weight);
	}
	public class TsRegularJumpStrategy implements TopSideCollideStrategy{
		public synchronized void topCollideHandler() {
			TsJump(-450);
		}
	}
	public class TsBreakableJumpStrategy implements TopSideCollideStrategy{
		public synchronized void topCollideHandler() {
			TsJump(-450);
			deleteObject();
		}
	}
	public class TsBlockJumpStrategy implements TopSideCollideStrategy{
		public synchronized void topCollideHandler() {
			TsJump(-650);
		}
	}
	
	public class TsLeftMoveStrategy implements TopSideCollideStrategy{
		public synchronized void topCollideHandler() {
			ball.updatePos(object.getX() - object.getLength()/2 - ball.getLength(), object.getY());
			constForces.clear();
			ball.updateVelocity(-600, 0);
		}
	}
	public class TsRightMoveStrategy implements TopSideCollideStrategy{
		public synchronized void topCollideHandler() {
			ball.updatePos(object.getX() + object.getLength()/2 + ball.getLength(), object.getY());
			constForces.clear();
			ball.updateVelocity(600, 0);
		}
	}
	//좌측 충돌 전략
	//1. 일반 점프(일반 블럭, 일회성 블럭, 좌우 이동 블럭, 가시)
	interface LeftSideCollideStrategy{
		public void leftCollideHandler();
	}
	
	public class LsRegularJumpStrategy implements LeftSideCollideStrategy {
		public synchronized void leftCollideHandler() {
			ball.updatePos(collidePos, ball.getY());
			ball.updateVelocity((ball.vx() - 80), ball.vy());
		}
	}	
	//우측 충돌 전략
	//1. 일반 점프(일반 블럭, 일회성 블럭, 좌우 이동 블럭, 가시)
	interface RightSideCollideStrategy{
		public void rightCollideHandler();
	}
	
	public class RsRegularJumpStrategy implements RightSideCollideStrategy {
		public synchronized void rightCollideHandler() {
			ball.updatePos(collidePos, ball.getY());
			ball.updateVelocity((ball.vx() +80), ball.vy());
		}
	}
	//하단 충돌 전략
	//1. 일반 점프(일반 블럭, 일회성 블럭, 좌우 이동 블럭, 가시)
	interface BottomSideCollideStrategy{
		public void bottomCollideHandler();
	}
	
	public class BsRegularJumpStrategy implements BottomSideCollideStrategy {
		public synchronized void bottomCollideHandler() {
			ball.updatePos(ball.getX(), collidePos);
			ball.updateVelocity(ball.vx(), (ball.vy() * -SBBMain.BOUNCE));
			if(ball.vy()>100) ball.updateVelocity(ball.vx(), 150);
			System.out.println("bottom collide");
		}
	}
	
	//전방향 충돌 전략
	//1. 아이템,별 획득 2. 리셋(전기)
	interface AllSideCollideStrategy{
		public void allCollideHandler();
	}

	public class GetItem1Strategy implements AllSideCollideStrategy{
		public synchronized void allCollideHandler() {
			deleteObject();
			SBBMain.inventory1 = true;
		}
	}
	public class GetItem2Strategy implements AllSideCollideStrategy{
		public synchronized void allCollideHandler() {
			deleteObject();
			SBBMain.inventory2 = true;
		}
	}
	public class GetStarStrategy implements AllSideCollideStrategy{
		public synchronized void allCollideHandler() {
			deleteObject();
			if(MakeMainScene.star==1) {
				try {
					Thread.sleep(650);
				} catch (Exception e) {}
				ball.updatePos(900, 1000);
			}
			MakeMainScene.star--;
		}
	}
	public class ElectricityCollideStrategy implements AllSideCollideStrategy{
		public synchronized void allCollideHandler() {
			resetGame();
		}
	}

}
