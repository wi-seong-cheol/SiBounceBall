package gamecomponents;

import moveengine.CollideGameComponent;
import moveengine.collidehandler.BreakableBlock;

public class SpawnBreakable extends Spawn{
	public SpawnBreakable(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 24;
		this.collideType = DIFFERACTION;
	}
	
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new BreakableBlock(CGC);
	}
}
