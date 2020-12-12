package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.topsidecollide.TsBreakableJumpStrategy;

public class BreakableBlock extends CollideHandler{
	public BreakableBlock(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsBreakableJumpStrategy());
		setRegularJumpApply();
	}
}
