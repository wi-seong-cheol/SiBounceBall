package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.topsidecollide.TsJumpBlockStrategy;

public class JumpBlock extends CollideHandler{
	public JumpBlock(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsJumpBlockStrategy());
		setRegularJumpApply();
	}
}
