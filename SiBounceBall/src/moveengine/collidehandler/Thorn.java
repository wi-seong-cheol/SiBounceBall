package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.topsidecollide.TsResetStrategy;

public class Thorn extends CollideHandler{
	public Thorn(CollideGameComponent CGC) {
		super(CGC);
		topCollide = new TsResetStrategy();
		regularJumpApply();
	}
}
