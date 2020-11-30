package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidestrategy.topsidecollide.TsBreakableJumpStrategy;
import view.ImageSet;

public class SpawnBreakable extends Spawn{
	public SpawnBreakable(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 24;
		this.collideType = DIFFERACTION;
	}
	
	public SpawnBreakable(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsBreakableJumpStrategy());
		setRegularJumpApply();
	}

	public Image getImage() {
		this.imageIcon = ImageSet.breakable;
		return this.imageIcon;
	}

	public int getTypeCode() {
		return Spawn.SPAWNBREAKABLE;
	}
}
