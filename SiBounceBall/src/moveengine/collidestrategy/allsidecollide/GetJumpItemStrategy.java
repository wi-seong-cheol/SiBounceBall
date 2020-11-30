package moveengine.collidestrategy.allsidecollide;

import model.Items;
import moveengine.CollideGameComponent;

public class GetJumpItemStrategy implements AllSideCollideStrategy{
	public void allCollideHandler(CollideGameComponent CGC) {
		CGC.deleteObject();
		Items.inventory2 = true;
	}
}
