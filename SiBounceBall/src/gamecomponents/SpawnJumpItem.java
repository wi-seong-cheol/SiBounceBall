package gamecomponents;

public class SpawnJumpItem extends Spawn{
	public SpawnJumpItem(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = SAMEACTION;
	}
	
}