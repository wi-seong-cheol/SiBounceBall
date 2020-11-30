package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.collidestrategy.topsidecollide.TsLeftMoveStrategy;

public class HorizontalMoveL extends CollideHandler{
	public HorizontalMoveL(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsLeftMoveStrategy());
		setRegularJumpApply();
	}
}
