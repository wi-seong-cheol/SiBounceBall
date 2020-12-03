package gamecomponents;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import moveengine.Accel;
import moveengine.CollideGameComponent;
import moveengine.CollideHandler;

public abstract class Spawn {
	protected double x, y, length;
	protected int type; 
	public int num=0; 
	protected ArrayList<Accel> Accelerations = new ArrayList<Accel>();
	protected Image imageIcon;

	public int collideType; 
	public static final int SAMEACTION = 0;
	public static final int DIFFERACTION = 1;
	
	
	public CollideHandler collideHandler;
	public abstract void setCollideHandler(CollideGameComponent CGC);
	
	public static Spawn newInstance() {
		return null;
	}
	
	public Spawn getInstance(int x, int y, int n) {
		System.out.println("??");
		return null;
	}
	
	public void updatePos(double newX, double newY)
	{
		this.x = newX;
		this.y = newY;
	}

	public Image getImage() {
		return this.imageIcon;
	}

	public double getLength()
	{
		return this.length;
	}

	public int getType()
	{
		return this.type;
	}

	public Point2D getCenter() 
	{
		return new Point2D.Double(this.x, this.y);
	}

	public double getX() 
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}

	public double getX1() 
	{
		return this.x - length/2;
	}

	public double getY1()
	{
		return this.y - length/2;
	}

	public double getX2() 
	{
		return this.x + length/2;
	}

	public double getY2()
	{
		return this.y + length/2;
	}

	public void setX(int newX)
	{
		this.x = newX;
	}

	public void setY(int newY)
	{
		this.y = newY;
	}

	public void setLength(int newLength) 
	{
		this.length = newLength;  
	}

}
