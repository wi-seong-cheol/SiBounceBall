package viewModel.moveengine.collidestrategy.topsidecollide;

import viewModel.moveengine.CollideGameComponent;

public class TsBreakableJumpStrategy implements TopSideCollideStrategy{
	public synchronized void topCollideHandler(CollideGameComponent CGC) {
		CGC.tsJump(-480);
		CGC.deleteObject();
	}
}
