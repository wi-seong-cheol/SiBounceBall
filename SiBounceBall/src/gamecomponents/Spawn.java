package gamecomponents;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import moveengine.Accel;
import moveengine.CollideGameComponent;
import moveengine.CollideHandler;
/* <type>
 * Ball
 * Wall
 * Jump
 * Thorn
 * Item1 : �븵���돩 -> 醫똮r�슦�궎 �늻瑜몄긽�깭�뿉�꽌 up�궎�엯�젰
 * Item2 : �젏�봽 -> spacebar �엯�젰
 * Star
 * Breakable
 * MoveL
 * MoveR
 */

public abstract class Spawn {
	protected double x, y, length;
	protected int type; // check collide 湲곗��씠 �썝�씤吏� �궗媛곹삎�씤吏� 援щ텇. 0 : �썝, 1 : �궗媛곹삎
	public int num=0; // �씠誘몄� 媛쒖닔媛� �뿬�윭媛쒖씤 obj留� �궗�슜
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

	public Point2D getCenter() // 以묒떖醫뚰몴 
	{
		return new Point2D.Double(this.x, this.y);
	}

	public double getX() // (X, Y)-> 以묒젏 醫뚰몴
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}

	public double getX1() //(X1, Y1)-> 醫�,�긽 �젏醫뚰몴
	{
		return this.x - length/2;
	}

	public double getY1()
	{
		return this.y - length/2;
	}

	public double getX2() //(X2, Y2)-> �슦,�븯 �젏醫뚰몴
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
