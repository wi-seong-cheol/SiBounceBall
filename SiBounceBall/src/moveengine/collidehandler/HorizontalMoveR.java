package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.topsidecollide.*;

public class HorizontalMoveR extends CollideHandler{
	public HorizontalMoveR(CollideGameComponent CGC) {
		super(CGC);
		topCollide = new TsRightMoveStrategy();
		regularJumpApply();
	}
}