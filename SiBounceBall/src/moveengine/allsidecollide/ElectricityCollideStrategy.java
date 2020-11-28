package moveengine.allsidecollide;

import moveengine.CollideGameComponent;

public class ElectricityCollideStrategy implements AllSideCollideStrategy{
	public void allCollideHandler(CollideGameComponent CGC) {
		CGC.resetGame();
	}
}