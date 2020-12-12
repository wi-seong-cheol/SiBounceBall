package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.topsidecollide.TsRegularJumpStrategy;

public class Wall extends CollideHandler{
	public Wall(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsRegularJumpStrategy());
		setRegularJumpApply();
	}
}
