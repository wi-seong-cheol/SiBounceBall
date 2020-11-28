package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.topsidecollide.TsLeftMoveStrategy;

public class HorizontalMoveL extends CollideHandler{
	public HorizontalMoveL(CollideGameComponent CGC) {
		super(CGC);
		topCollide = new TsLeftMoveStrategy();
		regularJumpApply();
	}
}
