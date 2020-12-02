package gamecomponents;

import moveengine.CollideGameComponent;
import moveengine.collidehandler.Thorn;

public class SpawnThorn extends Spawn{
	public SpawnThorn() {}
	
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
	
	public static SpawnThorn newInstance() {
		return new SpawnThorn();
	}
	
	public SpawnThorn getInstance(int x, int y, int n) {
		return new SpawnThorn(x, y, n);
	}
		
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new Thorn(CGC);
	}
}
