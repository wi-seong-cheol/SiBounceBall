package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.collidestrategy.topsidecollide.TsBreakableJumpStrategy;

public class BreakableBlock extends CollideHandler{
	public BreakableBlock(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsBreakableJumpStrategy());
		setRegularJumpApply();
	}
}
