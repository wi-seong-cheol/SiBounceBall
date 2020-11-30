package gamecomponents;

import moveengine.CollideGameComponent;
import moveengine.collidehandler.JumpBlock;

public class SpawnJump extends Spawn{
	public SpawnJump(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = DIFFERACTION;
	}
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new JumpBlock(CGC);
	}
}
