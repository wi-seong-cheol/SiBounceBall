package moveengine.topsidecollide;

import moveengine.CollideGameComponent;

public class TsRightMoveStrategy implements TopSideCollideStrategy{
	public synchronized void topCollideHandler(CollideGameComponent CGC) {
		CGC.tsHorizontalMove(CGC.RIGHT);
	}
}
