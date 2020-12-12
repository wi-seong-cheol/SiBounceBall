package viewModel.moveengine.collidestrategy.topsidecollide;

import viewModel.moveengine.CollideGameComponent;

public class TsRegularJumpStrategy implements TopSideCollideStrategy {
	public void topCollideHandler(CollideGameComponent CGC) {
		CGC.tsJump(-480);
	}
}
