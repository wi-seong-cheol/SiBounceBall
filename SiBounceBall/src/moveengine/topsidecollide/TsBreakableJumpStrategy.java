package moveengine.topsidecollide;

import moveengine.CollideGameComponent;

public class TsBreakableJumpStrategy implements TopSideCollideStrategy{
	public synchronized void topCollideHandler(CollideGameComponent CGC) {
		CGC.tsJump(-480);
		CGC.deleteObject();
	}
}
