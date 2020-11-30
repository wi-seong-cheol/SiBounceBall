package gamecomponents;

import moveengine.CollideGameComponent;
import moveengine.collidestrategy.topsidecollide.TsRegularJumpStrategy;

public class SpawnWall extends Spawn {
	public SpawnWall(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = DIFFERACTION;
	}
	
	public SpawnWall(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsRegularJumpStrategy());
		setRegularJumpApply();
	}
	
	public SpawnWall(int x, int y, int n)
	{
		this(x,y);
		this.num = n;
	}
	
	public int getTypeCode() {
		return Spawn.SPAWNWALL;
	}
}