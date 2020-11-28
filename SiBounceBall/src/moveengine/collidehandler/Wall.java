package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.topsidecollide.TsRegularJumpStrategy;

public class Wall extends CollideHandler{
	public Wall(CollideGameComponent CGC) {
		super(CGC);
		topCollide = new TsRegularJumpStrategy();
		regularJumpApply();
	}
}
