package moveengine;

import java.util.ArrayList;

import gamecomponents.Spawn;
import gamecomponents.SpawnBall;
import optimizedSBB.SBBMain;
import scenes.MakeGameComponents;

public class CollideGameComponent {
	public SpawnBall ball;
	public Spawn object;
	public ArrayList<Accel> constForces;
	public int collideObjIdx;
	public double collidePos;
	
	public final int ballIndex = 0;
	public final int LEFT = -1;
	public final int RIGHT = 1;
	
	public CollideGameComponent(Spawn object, int collideObjIdx, ArrayList<Accel> constForces) {
		this.ball = (SpawnBall) MakeGameComponents.living.get(ballIndex);
		this.object = object;
		this.collideObjIdx = collideObjIdx;
		this.constForces = constForces;
	}

	public void setCollidePos(double collidePos) {
		this.collidePos = collidePos;
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
	
	public void tsHorizontalMove(int weight) {
		ball.updatePos(object.getX() + (object.getLength() / 2) * weight 
				+ ball.getLength() * weight, object.getY());
		constForces.clear();
		ball.updateVelocity(600 * weight, 0);
	}

	public void regularCollide(int weight) {
		ball.updatePos(collidePos, ball.getY());
		ball.updateVelocity((ball.vx() + 80 * weight), ball.vy());
	}
}
