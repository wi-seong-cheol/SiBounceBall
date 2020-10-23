package Objects;

public class SpawnWall extends Spawn {
	public SpawnWall(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
	}
	
	public SpawnWall(int x, int y, int n)
	{
		this(x,y);
		this.num = n;
	}
	
}