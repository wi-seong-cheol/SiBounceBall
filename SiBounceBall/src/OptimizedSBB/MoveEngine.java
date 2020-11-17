package OptimizedSBB;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import Objects.*;
import Scenes.MakeGameComponents;
import Scenes.MakeMainScene;

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
		constForces.add(new Accel(0.0, SBBMain.GRAVITY));
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
					constForces.add(new Accel(0.0, SBBMain.GRAVITY)); // 멈춘자리에서 다시 튀어오름
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
				constForces.add(new Accel(0.0, SBBMain.GRAVITY));
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
			Spawn obj = MakeGameComponents.living.get(i); if (obj == null) break;
			if(obj.getType()==0) {
				isCollision = checkCircle(ball, obj);
			}
			else if(obj.getType()==1) {
				isCollision = checkRect(ball, obj);
			}
			if(isCollision) {
				double topSideChk = obj.getY() - obj.getLength() - ball.getLength();
				double downSideChk = obj.getY() + obj.getLength() + ball.getLength();
				double leftSideChk = obj.getX() - obj.getLength() - ball.getLength();
				double rightSideChk = obj.getX() + obj.getLength() + ball.getLength();
				CollideStrategyPattern collideObj = new CollideStrategyPattern(ball, obj, i, constForces);
				
				if(obj instanceof SpawnElectricity | obj instanceof SpawnItem1 | obj instanceof SpawnItem2|
					obj instanceof SpawnStar){
					collideObj.cObject.allCollideHandling();
				}
				else if((ball.getY() > topSideChk) && (ball.getY() < obj.getY())
						&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
					collideObj.setCollidePos(topSideChk);
					collideObj.cObject.topCollideHandling();
				}
				else if((ball.getY() < downSideChk) && (ball.getY() > obj.getY()) 
						&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk)) {
					collideObj.setCollidePos(downSideChk);
					collideObj.cObject.bottomCollideHandling();
				}
				else if((ball.getX() > leftSideChk) && (ball.getX() < obj.getX())) {
					collideObj.setCollidePos(leftSideChk);
					collideObj.cObject.leftCollideHandling();
				}
				else if((ball.getX() < rightSideChk) && (ball.getX() > obj.getX())) {
					collideObj.setCollidePos(rightSideChk);
					collideObj.cObject.rightCollideHandling();
				}
			}
		}
	}
	
	private synchronized void checkFrameCollisions(SpawnBall ball)
	{
		if (ball.getY() > SBBMain.Y + 1150) {
			if(constForces.size()==0)constForces.add(new Accel(0.0, SBBMain.GRAVITY));
			ball.updatePos(ball.startX, ball.startY);
			ball.updateVelocity(0, 0);
			SBBMain.sceneNum = -1;
		}
		if (ball.getX() > SBBMain.X + 900) {
			if(constForces.size()==0)constForces.add(new Accel(0.0, SBBMain.GRAVITY));
			ball.updatePos(ball.startX, ball.startY);
			ball.updateVelocity(0, 0);
			SBBMain.sceneNum = -1;
		}
		if (ball.getX() < -900) {
			if(constForces.size()==0)constForces.add(new Accel(0.0, SBBMain.GRAVITY));
			ball.updatePos(ball.startX, ball.startY);
			ball.updateVelocity(0, 0);
			SBBMain.sceneNum = -1;
		}

	}
}