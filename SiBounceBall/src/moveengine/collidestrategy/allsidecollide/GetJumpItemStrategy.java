package moveengine.collidestrategy.allsidecollide;

import moveengine.CollideGameComponent;
import optimizedSBB.SBBMain;

public class GetJumpItemStrategy implements AllSideCollideStrategy{
	public void allCollideHandler(CollideGameComponent CGC) {
		CGC.deleteObject();
		SBBMain.inventory2 = true;
	}
}
