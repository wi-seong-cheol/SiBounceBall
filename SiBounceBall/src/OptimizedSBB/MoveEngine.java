package OptimizedSBB;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import Objects.*;
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
		if(SBBMain.living.size()== 0) return; // Ball인스턴스를 인덱스로 접근하기 위함.
		double xAccel = 0, yAccel = 0;
		try {
			for (int i = 0; i < constForces.size(); i++) {
				xAccel += constForces.get(i).ax();
				yAccel += constForces.get(i).ay();
			}
			// Apply the sum acceleration to each entity.
			SpawnBall ball = (SpawnBall) SBBMain.living.get(ballIndex);
			ball.addAccel(new Accel(xAccel, yAccel));
		} catch (Exception e) {
			return;
		}
	}

	private synchronized void sumForces()
	{
		if(SBBMain.living.size()== 0) return;
		try {
			SpawnBall ball = (SpawnBall) SBBMain.living.get(ballIndex);
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
		if(SBBMain.living.size()== 0) return;
		try {
			SpawnBall ball = (SpawnBall) SBBMain.living.get(ballIndex);
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
		for (int i = 0; i < SBBMain.living.size(); i++) {
			if(i == ballIndex) continue;
			Spawn obj = SBBMain.living.get(i); if (obj == null) break;
			if(obj.getType()==0) {
				isCollision = checkCircle(ball, obj);
			}
			else if(obj.getType()==1) {
				isCollision = checkRect(ball, obj);
			}
			
			if(isCollision) {
				if(obj instanceof SpawnWall) {
					collideWall(ball, (SpawnWall) obj);
				}
				else if(obj instanceof SpawnJump) {
					collideJump(ball, (SpawnJump) obj);
				}
				else if(obj instanceof SpawnThorn) {
					collideThorn(ball, (SpawnThorn) obj);
				}
				else if(obj instanceof SpawnElectricity) {
					collideElectricity(ball, (SpawnElectricity) obj);
				}
				else if(obj instanceof SpawnItem1) {
					collideItem1(ball, (SpawnItem1) obj, i);
				}
				else if(obj instanceof SpawnItem2) {
					collideItem2(ball, (SpawnItem2) obj, i);
				}
				else if(obj instanceof SpawnStar) {
					collideStar(ball, (SpawnStar) obj, i);
				}
				else if(obj instanceof SpawnBreakable) {
					collideBreakable(ball, (SpawnBreakable) obj, i);
				}
				else if(obj instanceof SpawnMoveL) {
					collideMoveL(ball, (SpawnMoveL) obj);
				}
				else if(obj instanceof SpawnMoveR) {
					collideMoveR(ball, (SpawnMoveR) obj);
				}
			}
		}
	}

	private synchronized void collideWall(SpawnBall ball, SpawnWall wall)
	{
		double topSideChk = wall.getY() - wall.getLength()/2 - ball.getLength();
		double downSideChk = wall.getY() + wall.getLength()/2 + ball.getLength();
		double leftSideChk = wall.getX() - wall.getLength()/2 - ball.getLength();
		double rightSideChk = wall.getX() + wall.getLength()/2 + ball.getLength();
		
		if((ball.getY() > topSideChk) && (ball.getY() < wall.getY())
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(ball.getX(), topSideChk);
			ball.updateVelocity(ball.vx(), -500);
		}
		else if((ball.getY() < downSideChk) && (ball.getY() > wall.getY()) 
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(ball.getX(), downSideChk);
			ball.updateVelocity(ball.vx(), (ball.vy() * -SBBMain.BOUNCE));
			if(ball.vy()>100) ball.updateVelocity(ball.vx(), 150);
		}
		else if((ball.getX() > leftSideChk) && (ball.getX() < wall.getX())) {
			ball.updatePos(leftSideChk, ball.getY());
			ball.updateVelocity((ball.vx() -80), ball.vy());
		}
		else if((ball.getX() < rightSideChk) && (ball.getX() > wall.getX())) {
			ball.updatePos(rightSideChk, ball.getY());
			ball.updateVelocity((ball.vx() +80), ball.vy());
		}
		
	}
	
	private synchronized void collideJump(SpawnBall ball, SpawnJump jump)
	{
		double topSideChk = jump.getY() - jump.getLength()/2 - ball.getLength();
		double downSideChk = jump.getY() + jump.getLength()/2 + ball.getLength();
		double leftSideChk = jump.getX() - jump.getLength()/2 - ball.getLength();
		double rightSideChk = jump.getX() + jump.getLength()/2 + ball.getLength();
		
		
		if((ball.getY() > topSideChk) && (ball.getY() < jump.getY())
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(ball.getX(), topSideChk);
			ball.updateVelocity(ball.vx(), -720);
		}
		else if((ball.getY() < downSideChk) && (ball.getY() > jump.getY()) 
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(ball.getX(), downSideChk);
			ball.updateVelocity(ball.vx(), (ball.vy() * -SBBMain.BOUNCE));
			if(ball.vy()>100) ball.updateVelocity(ball.vx(), 150);
		}
		else if((ball.getX() > leftSideChk) && (ball.getX() < jump.getX())) {
			ball.updatePos(leftSideChk, ball.getY());
			ball.updateVelocity((ball.vx() -80), ball.vy());
		}
		else if((ball.getX() < rightSideChk) && (ball.getX() > jump.getX())) {
			ball.updatePos(rightSideChk, ball.getY());
			ball.updateVelocity((ball.vx() +80), ball.vy());
		}
	}
	
	private synchronized void collideThorn(SpawnBall ball, SpawnThorn thorn)
	{
		double topSideChk = thorn.getY() - thorn.getLength() - ball.getLength();
		double downSideChk = thorn.getY() + thorn.getLength() + ball.getLength();
		double leftSideChk = thorn.getX() - thorn.getLength() - ball.getLength();
		double rightSideChk = thorn.getX() + thorn.getLength() + ball.getLength();
		
		if((ball.getY() > topSideChk) && (ball.getY() < thorn.getY())
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(-150, 500);
			try {
				sleep(750);
			} catch (Exception e) {}
			ball.updatePos(ball.startX, ball.startY);
			ball.updateVelocity(0, 0);
			SBBMain.sceneNum = -1;
			// 이펙트 넣을시 death조건 만들어야함
		}
		else if((ball.getY() < downSideChk) && (ball.getY() > thorn.getY()) 
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk)) {
			ball.updatePos(ball.getX(), downSideChk);
			ball.updateVelocity(ball.vx(), (ball.vy() * -SBBMain.BOUNCE));
			if(ball.vy()>100) ball.updateVelocity(ball.vx(), 150);
		}
		else if((ball.getX() > leftSideChk) && (ball.getX() < thorn.getX())) {
			ball.updatePos(leftSideChk, ball.getY());
			ball.updateVelocity((ball.vx() -80), ball.vy());
		}
		else if((ball.getX() < rightSideChk) && (ball.getX() > thorn.getX())) {
			ball.updatePos(rightSideChk, ball.getY());
			ball.updateVelocity((ball.vx() +80), ball.vy());
		}
	}
	
	private synchronized void collideElectricity(SpawnBall ball, SpawnElectricity electricity)
	{
		ball.updatePos(-150, 500);
		try {
			sleep(750);
		} catch (Exception e) {}
		ball.updatePos(ball.startX, ball.startY);
		ball.updateVelocity(0, 0);
		SBBMain.sceneNum = -1;
	}
	
	private synchronized void collideItem1(SpawnBall ball, SpawnItem1 item1, int idx)
	{
		SBBMain.living.remove(idx);
		SBBMain.inventory1 = true;
	}
	
	private synchronized void collideItem2(SpawnBall ball, SpawnItem2 item2, int idx)
	{
		SBBMain.living.remove(idx);
		SBBMain.inventory2 = true;
	}
	
	private synchronized void collideStar(SpawnBall ball, SpawnStar star, int idx)
	{
		SBBMain.living.remove(idx);
		if(MakeMainScene.star==1) {
			try {
				sleep(650);
			} catch (Exception e) {}
			ball.updatePos(900, 1000);
		}
		MakeMainScene.star--;
	}
	
	private synchronized void collideBreakable(SpawnBall ball, SpawnBreakable breakable, int idx)
	{
		double topSideChk = breakable.getY() - breakable.getLength()/2 - ball.getLength();
		double downSideChk = breakable.getY() + breakable.getLength()/2 + ball.getLength();
		double leftSideChk = breakable.getX() - breakable.getLength()/2 - ball.getLength();
		double rightSideChk = breakable.getX() + breakable.getLength()/2 + ball.getLength();
		
		if((ball.getY() > topSideChk) && (ball.getY() < breakable.getY())
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(ball.getX(), topSideChk);
			ball.updateVelocity(ball.vx(), -500);
			SBBMain.living.remove(idx);
		}
		else if((ball.getY() < downSideChk) && (ball.getY() > breakable.getY()) 
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(ball.getX(), downSideChk);
			ball.updateVelocity(ball.vx(), (ball.vy() * -SBBMain.BOUNCE));
			if(ball.vy()>100) ball.updateVelocity(ball.vx(), 150);
		}
		else if((ball.getX() > leftSideChk) && (ball.getX() < breakable.getX())) {
			ball.updatePos(leftSideChk, ball.getY());
			ball.updateVelocity((ball.vx() -80), ball.vy());
		}
		else if((ball.getX() < rightSideChk) && (ball.getX() > breakable.getX())) {
			ball.updatePos(rightSideChk, ball.getY());
			ball.updateVelocity((ball.vx() +80), ball.vy());
		}
	}
	
	private synchronized void collideMoveL(SpawnBall ball, SpawnMoveL moveL) 
	{
		double topSideChk = moveL.getY() - moveL.getLength()/2 - ball.getLength();
		double downSideChk = moveL.getY() + moveL.getLength()/2 + ball.getLength();
		double leftSideChk = moveL.getX() - moveL.getLength()/2 - ball.getLength();
		double rightSideChk = moveL.getX() + moveL.getLength()/2 + ball.getLength();
		
		if((ball.getY() > topSideChk) && (ball.getY() < moveL.getY())
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(leftSideChk, moveL.getY());
			constForces.clear();
			ball.updateVelocity(-600, 0);
		}
		else if((ball.getY() < downSideChk) && (ball.getY() > moveL.getY()) 
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(ball.getX(), downSideChk);
			ball.updateVelocity(ball.vx(), (ball.vy() * -SBBMain.BOUNCE));
			if(ball.vy()>100) ball.updateVelocity(ball.vx(), 150);
		}
		else if((ball.getX() > leftSideChk) && (ball.getX() < moveL.getX())) {
			ball.updatePos(leftSideChk, ball.getY());
			ball.updateVelocity((ball.vx() -80), ball.vy());
		}
		else if((ball.getX() < rightSideChk) && (ball.getX() > moveL.getX())) {
			ball.updatePos(rightSideChk, ball.getY());
			ball.updateVelocity((ball.vx() +80), ball.vy());
		}
	}
	
	private synchronized void collideMoveR(SpawnBall ball, SpawnMoveR moveR)
	{
		double topSideChk = moveR.getY() - moveR.getLength()/2 - ball.getLength();
		double downSideChk = moveR.getY() + moveR.getLength()/2 + ball.getLength();
		double leftSideChk = moveR.getX() - moveR.getLength()/2 - ball.getLength();
		double rightSideChk = moveR.getX() + moveR.getLength()/2 + ball.getLength();
		
		if((ball.getY() > topSideChk) && (ball.getY() < moveR.getY())
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(rightSideChk, moveR.getY());
			constForces.clear();
			ball.updateVelocity(600, 0);
		}
		else if((ball.getY() < downSideChk) && (ball.getY() > moveR.getY()) 
				&& (ball.getX()-1.5 > leftSideChk) && (ball.getX()+1.5 < rightSideChk) ) {
			ball.updatePos(ball.getX(), downSideChk);
			ball.updateVelocity(ball.vx(), (ball.vy() * -SBBMain.BOUNCE));
			if(ball.vy()>100) ball.updateVelocity(ball.vx(), 150);
		}
		else if((ball.getX() > leftSideChk) && (ball.getX() < moveR.getX())) {
			ball.updatePos(leftSideChk, ball.getY());
			ball.updateVelocity((ball.vx() -80), ball.vy());
		}
		else if((ball.getX() < rightSideChk) && (ball.getX() > moveR.getX())) {
			ball.updatePos(rightSideChk, ball.getY());
			ball.updateVelocity((ball.vx() +80), ball.vy());
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