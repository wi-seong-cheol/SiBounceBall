package optimizedSBB;

import java.util.ArrayList;
import gamecomponents.Spawn;
import gamecomponents.SpawnBall;
import optimizedSBB.CollideStrategy.AllSideCollideStrategy;
import optimizedSBB.CollideStrategy.BottomSideCollideStrategy;
import optimizedSBB.CollideStrategy.LeftSideCollideStrategy;
import optimizedSBB.CollideStrategy.RightSideCollideStrategy;
import optimizedSBB.CollideStrategy.TopSideCollideStrategy;
import scenes.MakeGameComponents;
import scenes.MakeMainScene;

public class CollideStrategy {
	protected SpawnBall ball;
	protected Spawn object;
	protected ArrayList<Accel> constForces;
	protected int ballIndex = 0;
	protected int collideObjIdx;
	protected double collidePos;
	
	public CollideStrategy(Spawn object, int collideObjIdx, ArrayList<Accel> constForces) {
		this.ball = (SpawnBall)MakeGameComponents.living.get(ballIndex);
		this.object = object;
		this.collideObjIdx = collideObjIdx;
		this.constForces = constForces;
	}
	
	public void setCollidePos(double collidePos) {
		this.collidePos = collidePos;
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
			}
		}
		
		//전방향 충돌 전략
		//1. 아이템,별 획득 2. 리셋(전기)
		interface AllSideCollideStrategy{
			public void allCollideHandler();
		}

		public class GetDashItemStrategy implements AllSideCollideStrategy{
			public synchronized void allCollideHandler() {
				deleteObject();
				SBBMain.inventory1 = true;
			}
		}
		public class GetJumpItemStrategy implements AllSideCollideStrategy{
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
