package optimizedSBB;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import gamecomponents.*;
import scenes.MakeGameComponents;
import scenes.MakeMainScene;

public class CollideHandler extends CollideStrategy {
	public CollideGameComponent gameComponent;
	
	public CollideHandler(Spawn object, int collideObjIdx, ArrayList<Accel> constForces) {
		super(object, collideObjIdx, constForces);
		setCollideGameComponent();
	}
	
	public abstract class CollideGameComponent{
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
	
	public void setCollideGameComponent() {
		if(object instanceof SpawnWall) {
			gameComponent = new Wall();
		}
		else if(object instanceof SpawnJump) {
			gameComponent = new JumpBlock();
		}
		else if(object instanceof SpawnThorn) {
			gameComponent = new Thorn();
		}
		else if(object instanceof SpawnElectricity) {
			gameComponent = new Electricity();
		}
		else if(object instanceof SpawnDashItem) {
			gameComponent = new DashItem();
		}
		else if(object instanceof SpawnJumpItem) {
			gameComponent = new JumpItem();
		}
		else if(object instanceof SpawnStar) {
			gameComponent = new Star();
		}
		else if(object instanceof SpawnBreakable) {
			gameComponent = new BreakableBlock();
		}
		else if(object instanceof SpawnMoveL) {
			gameComponent = new HorizontalMoveL();
		}
		else if(object instanceof SpawnMoveR) {
			gameComponent = new HorizontalMoveR();
		}
	}
	
	public class Wall extends CollideGameComponent{
		public Wall() {
			topCollide = new TsRegularJumpStrategy();
			RegularJumpApply();
		}
	}
	public class BreakableBlock extends CollideGameComponent{
		public BreakableBlock() {
			topCollide = new TsBreakableJumpStrategy();
			RegularJumpApply();
		}
	}
	public class JumpBlock extends CollideGameComponent{
		public JumpBlock() {
			topCollide = new TsBlockJumpStrategy();
			RegularJumpApply();
		}
	}
	public class HorizontalMoveL extends CollideGameComponent{
		public HorizontalMoveL() {
			topCollide = new TsLeftMoveStrategy();
			RegularJumpApply();
		}
	}
	public class HorizontalMoveR extends CollideGameComponent{
		public HorizontalMoveR() {
			topCollide = new TsRightMoveStrategy();
			RegularJumpApply();
		}
	}
	public class Thorn extends CollideGameComponent{
		public Thorn() {
			topCollide = new TsResetStrategy();
			RegularJumpApply();
		}
	}
	public class Electricity extends CollideGameComponent{
		public Electricity() {
			allCollide = new ElectricityCollideStrategy();
		}
	}
	public class DashItem extends CollideGameComponent{
		public DashItem() {
			allCollide = new GetDashItemStrategy();
		}
	}
	public class JumpItem extends CollideGameComponent{
		public JumpItem() {
			allCollide = new GetJumpItemStrategy();
		}
	}
	public class Star extends CollideGameComponent{
		public Star() {
			allCollide = new GetStarStrategy();
		}
	}
}

