package viewModel.moveengine.collidestrategy.bottomsidecollide;

import model.PhysicalQuantity;
import viewModel.moveengine.CollideGameComponent;

public class BsRegularStrategy implements BottomSideCollideStrategy{
	public synchronized void bottomCollideHandler(CollideGameComponent CGC) {
		CGC.ball.updatePos(CGC.ball.getX(), CGC.collidePos);
		CGC.ball.updateVelocity(CGC.ball.vx(), (CGC.ball.vy() * - PhysicalQuantity.BOUNCE));
		if (CGC.ball.vy() > 100)
			CGC.ball.updateVelocity(CGC.ball.vx(), 150);
	}
}