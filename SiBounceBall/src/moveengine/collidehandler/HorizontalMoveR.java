package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.collidestrategy.topsidecollide.*;

public class HorizontalMoveR extends CollideHandler{
	public HorizontalMoveR(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsRightMoveStrategy());
		setRegularJumpApply();
	}
}