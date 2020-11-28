package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.allsidecollide.GetStarStrategy;

public class Star extends CollideHandler{
	public Star(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new GetStarStrategy();
	}
}
