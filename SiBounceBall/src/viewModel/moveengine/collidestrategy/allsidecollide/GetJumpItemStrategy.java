package viewModel.moveengine.collidestrategy.allsidecollide;

import model.Items;
import viewModel.moveengine.CollideGameComponent;

public class GetJumpItemStrategy implements AllSideCollideStrategy{
	public void allCollideHandler(CollideGameComponent CGC) {
		CGC.deleteObject();
		Items.inventory2 = true;
	}
}
