package moveengine.collidestrategy.topsidecollide;

import moveengine.CollideGameComponent;

public class TsJumpBlockStrategy implements TopSideCollideStrategy{
	public synchronized void topCollideHandler(CollideGameComponent CGC) {
		CGC.tsJump(-650);
	}
}