package viewModel.moveengine.collidehandler;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.CollideHandler;
import viewModel.moveengine.collidestrategy.allsidecollide.ElectricityCollideStrategy;

public class Electricity extends CollideHandler{
	public Electricity(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new ElectricityCollideStrategy();
	}
}