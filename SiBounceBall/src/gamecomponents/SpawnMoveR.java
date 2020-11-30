package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidestrategy.topsidecollide.TsRightMoveStrategy;
import view.ImageSet;

public class SpawnMoveR extends Spawn{
	public SpawnMoveR(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = DIFFERACTION;
	}
	
	public SpawnMoveR(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsRightMoveStrategy());
		setRegularJumpApply();
	}
	
	public Image getImage() {
		this.imageIcon = ImageSet.moveR;
		return this.imageIcon;
	}
	
	public int getTypeCode() {
		return Spawn.SPAWNMOVER;
	}
}
