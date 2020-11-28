package moveengine.rightsidecollide;

import moveengine.CollideGameComponent;

public class RsRegularStrategy implements RightSideCollideStrategy{
	public synchronized void rightCollideHandler(CollideGameComponent CGC) {
		CGC.regularCollide(CGC.RIGHT);
	}
}
