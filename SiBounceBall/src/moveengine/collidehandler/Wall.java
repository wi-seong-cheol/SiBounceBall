package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.collidestrategy.topsidecollide.TsRegularJumpStrategy;

public class Wall extends CollideHandler{
	public Wall(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsRegularJumpStrategy());
		setRegularJumpApply();
	}
}
