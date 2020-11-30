package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidehandler.Electricity;
import view.ImageSet;

public class SpawnElectricity extends Spawn
{ 
	public SpawnElectricity(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 0;
		this.length = 15.0;
		this.collideType = SAMEACTION;
	}
	
	 public void setCollideHandler(CollideGameComponent CGC) { 
			this.collideHandler = new Electricity(CGC);
	}

	public Image getImage() {
		this.imageIcon = ImageSet.electricity;
		return this.imageIcon;
	}

	public double getX1() //(X1, Y1)-> 좌상 점좌표
	{
		return this.x - length;
	}

	public double getY1()
	{
		return this.y - length;
	}

	public double getX2() //(X2, Y2)-> 우하 점좌표
	{
		return this.x + length;
	}

	public double getY2()
	{
		return this.y + length;
	}
}
