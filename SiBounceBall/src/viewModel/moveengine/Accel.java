package viewModel.moveengine;
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

//Accel을 넣은이유 : 공들끼리 충돌시 물리량을 표현하기 위해 -> 코드에서는 중력(질량없는 1500)만 작용

public class Accel
{
	private double ax, ay;

	public Accel(double ax, double ay)
	{
		this.ax = ax;
		this.ay = ay;
	}

	public double ax()
	{
		return this.ax;
	}

	public double ay()
	{
		return this.ay;
	}
}