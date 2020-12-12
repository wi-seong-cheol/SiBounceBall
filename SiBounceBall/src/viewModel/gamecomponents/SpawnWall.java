package viewModel.gamecomponents;

import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.collidehandler.Wall;

public class SpawnWall extends Spawn {
	public SpawnWall() {}
	
	public SpawnWall(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = DIFFERACTION;
	}
	
	public SpawnWall(int x, int y, int n)
	{
		this(x,y);
		this.num = n;
	}
	
	public static SpawnWall newInstance() {
		return new SpawnWall();
	}
	
	public SpawnWall getInstance(int x, int y, int n) {
		return new SpawnWall(x, y, n);
	}
	
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new Wall(CGC);
	}
}