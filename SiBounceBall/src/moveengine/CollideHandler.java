package moveengine;

import gamecomponents.Spawn;
import moveengine.collidestrategy.allsidecollide.*;
import moveengine.collidestrategy.bottomsidecollide.*;
import moveengine.collidestrategy.leftsidecollide.*;
import moveengine.collidestrategy.rightsidecollide.*;
import moveengine.collidestrategy.topsidecollide.*;

public abstract class CollideHandler {
	protected TopSideCollideStrategy topCollide = null;
	protected BottomSideCollideStrategy bottomCollide = null;
	protected LeftSideCollideStrategy leftCollide = null;
	protected RightSideCollideStrategy rightCollide = null;
	protected AllSideCollideStrategy allCollide = null;
	
	protected CollideGameComponent CGC;
	
	public CollideHandler(CollideGameComponent CGC) {
		this.CGC = CGC;
	}
	
	public void collideHandling() {
		if(CGC.object.collideType == Spawn.SAMEACTION){
			allCollide.allCollideHandler(CGC);
		}
		else if(CGC.collideDirection == CGC.TOP) {
			topCollide.topCollideHandler(CGC);
		}
		else if(CGC.collideDirection == CGC.BOTTOM) {
			bottomCollide.bottomCollideHandler(CGC);
		}
		else if(CGC.collideDirection == CGC.LEFT) {
			leftCollide.leftCollideHandler(CGC);
		}
		else if(CGC.collideDirection == CGC.RIGHT) {
			rightCollide.rightCollideHandler(CGC);
		}
	}
	
	public void setTopCollideStrategy(TopSideCollideStrategy ts) {
		topCollide = ts;
	}
	
	public void setRegularJumpApply() {
		bottomCollide = new BsRegularStrategy();
		leftCollide = new LsRegularStrategy();
		rightCollide = new RsRegularStrategy();
	}
}
