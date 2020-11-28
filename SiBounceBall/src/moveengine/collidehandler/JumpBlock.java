package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.collidestrategy.topsidecollide.TsJumpBlockStrategy;

public class JumpBlock extends CollideHandler{
	public JumpBlock(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsJumpBlockStrategy());
		setRegularJumpApply();
	}
}
