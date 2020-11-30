package gamecomponents;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import moveengine.Accel;
/* <type>
 * Ball
 * Wall
 * Jump
 * Thorn
 * Item1 : 앞대쉬 -> 좌or우키 누른상태에서 up키입력
 * Item2 : 점프 -> spacebar 입력
 * Star
 * Breakable
 * MoveL
 * MoveR
 */
import moveengine.CollideGameComponent;
import moveengine.collidestrategy.allsidecollide.AllSideCollideStrategy;
import moveengine.collidestrategy.bottomsidecollide.BottomSideCollideStrategy;
import moveengine.collidestrategy.bottomsidecollide.BsRegularStrategy;
import moveengine.collidestrategy.leftsidecollide.LeftSideCollideStrategy;
import moveengine.collidestrategy.leftsidecollide.LsRegularStrategy;
import moveengine.collidestrategy.rightsidecollide.RightSideCollideStrategy;
import moveengine.collidestrategy.rightsidecollide.RsRegularStrategy;
import moveengine.collidestrategy.topsidecollide.TopSideCollideStrategy;

public abstract class Spawn {
	protected double x, y, length;
	protected int type; // check collide 기준이 원인지 사각형인지 구분. 0 : 원, 1 : 사각형
	public int num=0; // 이미지 개수가 여러개인 obj만 사용
	protected ArrayList<Accel> Accelerations = new ArrayList<Accel>();
	protected Image imageIcon;

	static final int SPAWNBALL = 0;
	static final int SPAWNBREAKABLE = 1;
	static final int SPAWNDASHITEM = 2;
	static final int SPAWNELECTRICITY = 3;
	static final int SPAWNJUMP = 4;
	static final int SPAWNJUMPITEM = 5;
	static final int SPAWNMOVEL = 6;
	static final int SPAWNMOVER = 7;
	static final int SPAWNSTAR = 8;
	static final int SPAWNTHORN = 9;
	static final int SPAWNWALL = 10;

	public int collideType; 
	public static final int SAMEACTION = 0;
	public static final int DIFFERACTION = 1;
	
	public abstract int getTypeCode();
	protected TopSideCollideStrategy topCollide = null;
	protected BottomSideCollideStrategy bottomCollide = null;
	protected LeftSideCollideStrategy leftCollide = null;
	protected RightSideCollideStrategy rightCollide = null;
	protected AllSideCollideStrategy allCollide = null;
	
	protected CollideGameComponent CGC;
	
	public Spawn(int x, int y){}
	
	public Spawn(CollideGameComponent CGC) {
		this.CGC = CGC;
	}
	
	public void collideHandling() {
		if(CGC.object.collideType == Spawn.SAMEACTION){
			allCollide.allCollideHandler(CGC);
		}
		else if(CGC.collideDirection == CGC.TOP) {
			topCollide.topCollideHandler(CGC);
		}
		else if(CGC.collideDirection == CGC.BOTTOM) {
			bottomCollide.bottomCollideHandler(CGC);
		}
		else if(CGC.collideDirection == CGC.LEFT) {
			leftCollide.leftCollideHandler(CGC);
		}
		else if(CGC.collideDirection == CGC.RIGHT) {
			rightCollide.rightCollideHandler(CGC);
		}
	}
	
	public void setTopCollideStrategy(TopSideCollideStrategy ts) {
		topCollide = ts;
	}
	
	public void setRegularJumpApply() {
		bottomCollide = new BsRegularStrategy();
		leftCollide = new LsRegularStrategy();
		rightCollide = new RsRegularStrategy();
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

	public Point2D getCenter() // 중심좌표 
	{
		return new Point2D.Double(this.x, this.y);
	}

	public double getX() // (X, Y)-> 중점 좌표
	{
		return this.x;
	}

	public double getY()
	{
		return this.y;
	}

	public double getX1() //(X1, Y1)-> 좌,상 점좌표
	{
		return this.x - length/2;
	}

	public double getY1()
	{
		return this.y - length/2;
	}

	public double getX2() //(X2, Y2)-> 우,하 점좌표
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
