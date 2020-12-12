package viewModel.gamecomponents;
import java.awt.Image;
import java.util.ArrayList;

import view.ImageSet;
import viewModel.moveengine.Accel;
import viewModel.moveengine.CollideGameComponent;

public class SpawnBall extends Spawn
{
	public static double vx, vy; // 싱글톤 사용하지 않고 static vx, vy사용한 이유 : 여러개의 공 충돌구현 때문에 싱글톤X함
	public int startX, startY;
	private ArrayList<Accel> Accelerations = new ArrayList<Accel>();

	public SpawnBall(int x, int y) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.vx = 0;
		this.vy = 0;
		this.type = 0;
		this.length = 13.0; // 반지름 !!
		this.collideType = DIFFERACTION;
	}

	public void setCollideHandler(CollideGameComponent CGC) { }
	
	public Image getImage() {
		this.imageIcon = ImageSet.sibaball;
		return this.imageIcon;
	}

	public Accel sumAccel()
	{
		double xAccel = 0, yAccel = 0;
		for (int i = 0; i < this.Accelerations.size(); i++) {
			xAccel += this.Accelerations.get(i).ax();
			yAccel += this.Accelerations.get(i).ay();
		}
		this.Accelerations.clear();
		return new Accel(xAccel, yAccel);
	}

	public void addAccel(Accel a)
	{
		this.Accelerations.add(a);
	}

	public void clearAccel()
	{
		this.Accelerations.clear();
	}

	public void updateVelocity(double vx, double vy)
	{
		this.vx = vx;
		this.vy = vy;
	}

	public double vx()
	{
		return this.vx;
	}

	public double vy()
	{
		return this.vy;
	}

	@Override
	public double getX1() //(X1, Y1)-> 좌,상 점좌표
	{
		return this.x - length;
	}
	@Override
	public double getY1()
	{
		return this.y - length;
	}
	@Override
	public double getX2() //(X2, Y2)-> 우,하 점좌표
	{
		return this.x + length;
	}
	@Override
	public double getY2()
	{
		return this.y + length;
	}
}
