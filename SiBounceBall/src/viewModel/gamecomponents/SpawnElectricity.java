package viewModel.gamecomponents;

import java.awt.Image;

import view.ImageSet;
import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.collidehandler.Electricity;

public class SpawnElectricity extends Spawn{
	public SpawnElectricity() {}
	
	public SpawnElectricity(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 0;
		this.length = 15.0;
		this.collideType = SAMEACTION;
	}
	
	public static SpawnElectricity newInstance() {
		return new SpawnElectricity();
	}
	
	public SpawnElectricity getInstance(int x, int y, int n) {
		return new SpawnElectricity(x, y);
	}
	
	 public void setCollideHandler(CollideGameComponent CGC) { 
			this.collideHandler = new Electricity(CGC);
	}

	public Image getImage() {
		this.imageIcon = ImageSet.electricity;
		return this.imageIcon;
	}

	public double getX1() //(X1, Y1)-> 醫뚯긽 �젏醫뚰몴
	{
		return this.x - length;
	}

	public double getY1()
	{
		return this.y - length;
	}

	public double getX2() //(X2, Y2)-> �슦�븯 �젏醫뚰몴
	{
		return this.x + length;
	}

	public double getY2()
	{
		return this.y + length;
	}
}
