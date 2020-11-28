package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.collidestrategy.allsidecollide.GetJumpItemStrategy;

public class JumpItem extends CollideHandler{
	public JumpItem(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new GetJumpItemStrategy();
	}
}
