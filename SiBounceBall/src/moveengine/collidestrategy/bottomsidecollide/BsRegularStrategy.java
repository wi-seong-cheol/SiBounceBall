package moveengine.collidestrategy.bottomsidecollide;

import moveengine.CollideGameComponent;
import optimizedSBB.SBBMain;

public class BsRegularStrategy implements BottomSideCollideStrategy{
	public synchronized void bottomCollideHandler(CollideGameComponent CGC) {
		CGC.ball.updatePos(CGC.ball.getX(), CGC.collidePos);
		CGC.ball.updateVelocity(CGC.ball.vx(), (CGC.ball.vy() * -SBBMain.BOUNCE));
		if (CGC.ball.vy() > 100)
			CGC.ball.updateVelocity(CGC.ball.vx(), 150);
	}
}