package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.allsidecollide.GetDashItemStrategy;

public class DashItem extends CollideHandler{
	public DashItem(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new GetDashItemStrategy();
	}
}
