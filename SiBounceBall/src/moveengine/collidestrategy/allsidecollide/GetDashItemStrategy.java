package moveengine.collidestrategy.allsidecollide;

import model.Items;
import moveengine.CollideGameComponent;

public class GetDashItemStrategy implements AllSideCollideStrategy{
	public void allCollideHandler(CollideGameComponent CGC) {
		CGC.deleteObject();
		Items.inventory1 = true;
	}
}
