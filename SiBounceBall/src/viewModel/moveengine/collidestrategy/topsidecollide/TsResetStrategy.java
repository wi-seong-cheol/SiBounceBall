package viewModel.moveengine.collidestrategy.topsidecollide;

import viewModel.moveengine.CollideGameComponent;

public class TsResetStrategy implements TopSideCollideStrategy {
	public synchronized void topCollideHandler(CollideGameComponent CGC) {
		CGC.resetGame();
	}
}
