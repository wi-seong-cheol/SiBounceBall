package moveengine;

import java.util.ArrayList;

import gamecomponents.Spawn;
import gamecomponents.SpawnBall;
import gamecomponents.SpawnThorn;
import optimizedSBB.SBBMain;
import scenes.MakeGameComponents;

public class CollideGameComponent {
	public SpawnBall ball;
	public Spawn object;
	public ArrayList<Accel> constForces;
	public int collideObjIdx;
	
	public double topBorder;
	public double leftBorder;
	public double rightBorder;
	public double bottomBorder;
	public int collideDirection;
	public double collidePos;
	
	public final int ballIndex = 0;
	public final int TOP = 0;
	public final int LEFT = -1;
	public final int RIGHT = 1;
	public final int BOTTOM = 2;
	
	public CollideGameComponent(Spawn object, int collideObjIdx, ArrayList<Accel> constForces) {
		this.ball = (SpawnBall) MakeGameComponents.living.get(ballIndex);
		this.object = object;
		this.collideObjIdx = collideObjIdx;
		this.constForces = constForces;
		
		if(object instanceof SpawnThorn) {
			setBorderVal(1);
		}
		else {
			setBorderVal(2);
		}
		setCollideBorder();
	}

	public void setCollidePos(double collidePos) {
		this.collidePos = collidePos;
	}
	public void setBorderVal(int weight) {
		topBorder = object.getY() - object.getLength()/weight - ball.getLength();
		leftBorder = object.getX() - object.getLength()/weight - ball.getLength();
		rightBorder = object.getX() + object.getLength()/weight + ball.getLength();
		bottomBorder = object.getY() + object.getLength()/weight + ball.getLength();
	}
	
	public void setCollideBorder() {
		if((ball.getY() > topBorder) && (ball.getY() < object.getY())
				&& (ball.getX()-1.5 >= leftBorder) && (ball.getX()+1.5 <= rightBorder) ) {
			collideDirection = TOP;
			setCollidePos(topBorder);
		}
		else if((ball.getY() < bottomBorder) && (ball.getY() > object.getY()) 
				&& (ball.getX()-1.5 > leftBorder) && (ball.getX()+1.5 < rightBorder)) {
			collideDirection = BOTTOM;
			setCollidePos(bottomBorder);
		}
		else if((ball.getX() > leftBorder) && (ball.getX() < object.getX())) {
			collideDirection = LEFT;
			setCollidePos(leftBorder);
		}
		else if((ball.getX() < rightBorder) && (ball.getX() > object.getX())) {
			collideDirection = RIGHT;
			setCollidePos(rightBorder);
		}
	}

	// 전략의 메소드 화
	public void resetGame() {
		ball.updatePos(-150, 500);
		try {
			Thread.sleep(750);
		} catch (Exception e) {
		}
		ball.updatePos(ball.startX, ball.startY);
		ball.updateVelocity(0, 0);
		SBBMain.sceneNum = -1;
	}

	public void deleteObject() {
		MakeGameComponents.living.remove(collideObjIdx);
	}
	
	public void tsJump(int weight) {
		ball.updatePos(ball.getX(), collidePos);
		ball.updateVelocity(ball.vx(), weight);
	}
	
	public void tsHorizontalMove(int type) {
		double borderVal = 0;
		if(type == LEFT) { borderVal = leftBorder; }
		else if(type == RIGHT) { borderVal = rightBorder; }
		
		ball.updatePos(borderVal, object.getY());
		constForces.clear();
		ball.updateVelocity(600 * type, 0);
	}

	public void regularCollide(int weight) {
		ball.updatePos(collidePos, ball.getY());
		ball.updateVelocity((ball.vx() + 80 * weight), ball.vy());
	}
}
