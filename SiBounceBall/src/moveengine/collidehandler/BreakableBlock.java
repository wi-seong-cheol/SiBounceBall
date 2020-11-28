package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.topsidecollide.TsBreakableJumpStrategy;

public class BreakableBlock extends CollideHandler{
	public BreakableBlock(CollideGameComponent CGC) {
		super(CGC);
		topCollide = new TsBreakableJumpStrategy();
		regularJumpApply();
	}
}
