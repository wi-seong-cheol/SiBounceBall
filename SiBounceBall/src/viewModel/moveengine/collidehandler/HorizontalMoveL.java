package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.topsidecollide.TsLeftMoveStrategy;

public class HorizontalMoveL extends CollideHandler{
	public HorizontalMoveL(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsLeftMoveStrategy());
		setRegularJumpApply();
	}
}
