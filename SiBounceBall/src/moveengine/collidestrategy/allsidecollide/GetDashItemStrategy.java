package moveengine.collidestrategy.allsidecollide;

import moveengine.CollideGameComponent;
import optimizedSBB.SBBMain;

public class GetDashItemStrategy implements AllSideCollideStrategy{
	public void allCollideHandler(CollideGameComponent CGC) {
		CGC.deleteObject();
		SBBMain.inventory1 = true;
	}
}
