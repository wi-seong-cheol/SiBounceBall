package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.allsidecollide.GetJumpItemStrategy;

public class JumpItem extends CollideHandler{
	public JumpItem(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new GetJumpItemStrategy();
	}
}
