package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.topsidecollide.TsJumpBlockStrategy;

public class JumpBlock extends CollideHandler{
	public JumpBlock(CollideGameComponent CGC) {
		super(CGC);
		topCollide = new TsJumpBlockStrategy();
		regularJumpApply();
	}
}
