package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.allsidecollide.GetDashItemStrategy;

public class DashItem extends CollideHandler{
	public DashItem(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new GetDashItemStrategy();
	}
}
