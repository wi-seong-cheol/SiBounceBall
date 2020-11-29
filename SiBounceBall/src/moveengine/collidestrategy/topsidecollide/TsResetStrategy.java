package moveengine.collidestrategy.topsidecollide;

import moveengine.CollideGameComponent;

public class TsResetStrategy implements TopSideCollideStrategy {
	public synchronized void topCollideHandler(CollideGameComponent CGC) {
		CGC.resetGame();
	}
}
