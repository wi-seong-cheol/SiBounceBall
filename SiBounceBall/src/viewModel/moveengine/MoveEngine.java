package viewModel.moveengine;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import model.PhysicalQuantity;
import model.SceneInformation;
import view.MakeGameComponents;
import viewModel.SBBMain;
import viewModel.gamecomponents.*;

public class MoveEngine extends Thread
{
	private long timePassed = 0;
	private long curTime = 0;
	private long lastTime = 0;
	private double timeFraction = 0.0;
	private int ballIndex = 0; // ball은 Scene에서 항상 첫번째로 만들기 때문.
	public static ArrayList<Accel> constForces = new ArrayList<Accel>();
	
	public void run()
	{
		curTime = System.currentTimeMillis();
		initializeConstForces(); // 중력++
		while (SBBMain.isRunning) {
			updateTime();
			applyConstForces();
			sumForces();
			moveEnts();
			
			try {
				sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
	
	private void updateTime()
	{
		lastTime = curTime;
		curTime = System.currentTimeMillis();
		timePassed = (curTime - lastTime);
		timeFraction = (timePassed / 1000.0);
	}

	private void initializeConstForces()
	{
		constForces.add(new Accel(0.0, PhysicalQuantity.GRAVITY));
	}

	private synchronized void applyConstForces()
	
	{
		if(MakeGameComponents.living.size()== 0) return; // Ball인스턴스를 인덱스로 접근하기 위함.
		double xAccel = 0, yAccel = 0;
		try {
			for (int i = 0; i < constForces.size(); i++) {
				xAccel += constForces.get(i).ax();
				yAccel += constForces.get(i).ay();
			}
			// Apply the sum acceleration to each entity.
			SpawnBall ball = (SpawnBall) MakeGameComponents.living.get(ballIndex);
			ball.addAccel(new Accel(xAccel, yAccel));
		} catch (Exception e) {
			return;
		}
	}

	private synchronized void sumForces()
	{
		if(MakeGameComponents.living.size()== 0) return;
		try {
			SpawnBall ball = (SpawnBall) MakeGameComponents.living.get(ballIndex);
			// Get the sum of all accelerations acting on object.
			Accel theAccel = ball.sumAccel();
			// Apply the resulting change in velocity.
			double vx = ball.vx() + (theAccel.ax() * timeFraction);
			double vy = ball.vy() + (theAccel.ay() * timeFraction );
			ball.updateVelocity(vx, vy);
		} catch (Exception e) {
			return;
		}
	}

	private synchronized void moveEnts()
	{
		if(MakeGameComponents.living.size()== 0) return;
		try {
			SpawnBall ball = (SpawnBall) MakeGameComponents.living.get(ballIndex);
			double oldX = ball.getX(), oldY = ball.getY();
			double newX = oldX + (ball.vx() * timeFraction);
			double newY = oldY + (ball.vy() * timeFraction);
			ball.updatePos(newX, newY);
			checkFrameCollisions(ball);
			checkCollisions(ball);
		} catch (Exception e) {
			return;
		}
		
	}
	private synchronized boolean checkRect(SpawnBall ball, Spawn obj)
	{
		if( ( (ball.getX1() < obj.getX2()) && (obj.getX1() < ball.getX2()) ) 
				&& ( (ball.getY1() < obj.getY2()) && (obj.getY1() < ball.getY2()) ) )
		{
			if(constForces.size()==0) {
				if(!(obj instanceof SpawnStar)) { // moveL or R 상태로 벽충돌시에
					ball.updateVelocity(0, 0); // 잠깐 멈춤
					constForces.add(new Accel(0.0, PhysicalQuantity.GRAVITY)); // 멈춘자리에서 다시 튀어오름
				}
				else {
					
				}
			}
			return true;
		} 
		else return false;
	}
	
	private synchronized boolean checkCircle(SpawnBall ball, Spawn obj)
	{
		
		Point2D ballCenter = ball.getCenter();
		Point2D objCenter = obj.getCenter();
		if (ballCenter.distance(objCenter) < (ball.getLength() + obj.getLength())) {
			if(constForces.size()==0) {
				ball.updateVelocity(0, 0);
				constForces.add(new Accel(0.0, PhysicalQuantity.GRAVITY));
			}
			return true;
		}
		else return false;
	}

	private synchronized void checkCollisions(SpawnBall ball)
	{
		boolean isCollision = false;
		for (int i = 0; i < MakeGameComponents.living.size(); i++) {
			if(i == ballIndex) continue;
			Spawn collideObj = MakeGameComponents.living.get(i); if (collideObj == null) break;
			if(collideObj.getType()==0) {
				isCollision = checkCircle(ball, collideObj);
			}
			else if(collideObj.getType()==1) {
				isCollision = checkRect(ball, collideObj);
			}
			if(isCollision) {
				CollideGameComponent CGC = new CollideGameComponent(collideObj,i,constForces);
				collideObj.setCollideHandler(CGC);
				collideObj.collideHandler.collideHandling();
			}
		}
	}
	
	private synchronized void checkFrameCollisions(SpawnBall ball)
	{
		if (ball.getY() > SceneInformation.Y + 1150) {
			if(constForces.size()==0)constForces.add(new Accel(0.0, PhysicalQuantity.GRAVITY));
			ball.updatePos(ball.startX, ball.startY);
			ball.updateVelocity(0, 0);
			SceneInformation.sceneNum = -1;
		}
		if (ball.getX() > SceneInformation.X + 900) {
			if(constForces.size()==0)constForces.add(new Accel(0.0, PhysicalQuantity.GRAVITY));
			ball.updatePos(ball.startX, ball.startY);
			ball.updateVelocity(0, 0);
			SceneInformation.sceneNum = -1;
		}
		if (ball.getX() < -900) {
			if(constForces.size()==0)constForces.add(new Accel(0.0, PhysicalQuantity.GRAVITY));
			ball.updatePos(ball.startX, ball.startY);
			ball.updateVelocity(0, 0);
			SceneInformation.sceneNum = -1;
		}

	}
}