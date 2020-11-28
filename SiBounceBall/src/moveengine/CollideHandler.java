package moveengine;

import moveengine.allsidecollide.*;
import moveengine.bottomsidecollide.*;
import moveengine.leftsidecollide.*;
import moveengine.rightsidecollide.*;
import moveengine.topsidecollide.*;


public abstract class CollideHandler {
	protected TopSideCollideStrategy topCollide;
	protected BottomSideCollideStrategy bottomCollide;
	protected LeftSideCollideStrategy leftCollide;
	protected RightSideCollideStrategy rightCollide;
	protected AllSideCollideStrategy allCollide;
	
	protected CollideGameComponent CGC;
	
	public CollideHandler(CollideGameComponent CGC) {
		this.CGC = CGC;
	}
	
	public synchronized void regularJumpApply() {
		bottomCollide = new BsRegularStrategy();
		leftCollide = new LsRegularStrategy();
		rightCollide = new RsRegularStrategy();
	}
	
	public synchronized void topCollideHandling() {
		topCollide.topCollideHandler(CGC);
	}
	public synchronized void leftCollideHandling() {
		leftCollide.leftCollideHandler(CGC);
	}
	public synchronized void rightCollideHandling() {
		rightCollide.rightCollideHandler(CGC);
	}
	public synchronized void bottomCollideHandling() {
		bottomCollide.bottomCollideHandler(CGC);
	}
	public synchronized void allCollideHandling() {
		allCollide.allCollideHandler(CGC);
	}
	
}
