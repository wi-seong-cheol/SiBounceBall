package gamecomponents;

import moveengine.CollideGameComponent;
import moveengine.collidehandler.Thorn;

public class SpawnThorn extends Spawn{
	public SpawnThorn(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 0;
		this.length = 14;
		this.collideType = DIFFERACTION;
	}
	
	public SpawnThorn(int x, int y, int n)
	{
		this(x,y);
		this.num = n;
	}
	
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new Thorn(CGC);
	}
}
