package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidestrategy.topsidecollide.TsLeftMoveStrategy;
import view.ImageSet;

public class SpawnMoveL extends Spawn{
	public SpawnMoveL(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = DIFFERACTION;
	}
	
	public SpawnMoveL(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsLeftMoveStrategy());
		setRegularJumpApply();
	}

	public Image getImage() {
		this.imageIcon = ImageSet.moveL;
		return this.imageIcon;
	}
	
	public int getTypeCode() {
		return Spawn.SPAWNMOVEL;
	}
}
