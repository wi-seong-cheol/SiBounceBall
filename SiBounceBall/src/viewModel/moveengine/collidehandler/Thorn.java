package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.topsidecollide.TsResetStrategy;

public class Thorn extends CollideHandler{
	public Thorn(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsResetStrategy());
		setRegularJumpApply();
	}
}
