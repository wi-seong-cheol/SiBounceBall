package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.allsidecollide.GetStarStrategy;

public class Star extends CollideHandler{
	public Star(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new GetStarStrategy();
	}
}
