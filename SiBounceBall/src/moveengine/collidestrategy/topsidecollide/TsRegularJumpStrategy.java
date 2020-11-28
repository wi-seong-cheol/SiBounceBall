package moveengine.collidestrategy.topsidecollide;

import moveengine.CollideGameComponent;

public class TsRegularJumpStrategy implements TopSideCollideStrategy {
	public void topCollideHandler(CollideGameComponent CGC) {
		CGC.tsJump(-480);
	}
}
