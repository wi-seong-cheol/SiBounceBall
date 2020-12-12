package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.topsidecollide.*;

public class HorizontalMoveR extends CollideHandler{
	public HorizontalMoveR(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsRightMoveStrategy());
		setRegularJumpApply();
	}
}