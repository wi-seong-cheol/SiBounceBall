package moveengine.leftsidecollide;

import moveengine.CollideGameComponent;

public class LsRegularStrategy implements LeftSideCollideStrategy{
	public synchronized void leftCollideHandler(CollideGameComponent CGC) {
		CGC.regularCollide(CGC.LEFT);
	}
}