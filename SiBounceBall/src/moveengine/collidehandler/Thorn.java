package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.collidestrategy.topsidecollide.TsResetStrategy;

public class Thorn extends CollideHandler{
	public Thorn(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsResetStrategy());
		setRegularJumpApply();
	}
}
