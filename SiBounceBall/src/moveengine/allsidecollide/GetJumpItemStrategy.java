package moveengine.allsidecollide;

import moveengine.CollideGameComponent;
import optimizedSBB.SBBMain;

public class GetJumpItemStrategy implements AllSideCollideStrategy{
	public void allCollideHandler(CollideGameComponent CGC) {
		System.out.print("jumpItem\n");
		CGC.deleteObject();
		SBBMain.inventory2 = true;
	}
}
