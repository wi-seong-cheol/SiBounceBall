package moveengine.collidehandler;

import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
import moveengine.allsidecollide.ElectricityCollideStrategy;

public class Electricity extends CollideHandler{
	public Electricity(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new ElectricityCollideStrategy();
	}
}