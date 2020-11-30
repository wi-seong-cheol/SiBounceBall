package gamecomponents;

import moveengine.CollideGameComponent;
import moveengine.collidestrategy.topsidecollide.TsResetStrategy;

public class SpawnThorn extends Spawn{
	public SpawnThorn(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.type = 0;
		this.length = 14;
		this.collideType = DIFFERACTION;
	}
	
	public SpawnThorn(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsResetStrategy());
		setRegularJumpApply();
	}

	public SpawnThorn(int x, int y, int n)
	{
		this(x,y);
		this.num = n;
	}
	
	public int getTypeCode() {
		return Spawn.SPAWNTHORN;
	}
}
