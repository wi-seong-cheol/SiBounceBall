package moveengine.collidestrategy.topsidecollide;

import moveengine.CollideGameComponent;

public class TsLeftMoveStrategy implements TopSideCollideStrategy{
	public synchronized void topCollideHandler(CollideGameComponent CGC) {
		CGC.tsHorizontalMove(CGC.LEFT);
	}
}
