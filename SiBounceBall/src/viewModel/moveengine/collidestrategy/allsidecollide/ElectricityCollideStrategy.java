package viewModel.moveengine.collidestrategy.allsidecollide;

import viewModel.moveengine.CollideGameComponent;

public class ElectricityCollideStrategy implements AllSideCollideStrategy{
	public void allCollideHandler(CollideGameComponent CGC) {
		CGC.resetGame();
	}
}