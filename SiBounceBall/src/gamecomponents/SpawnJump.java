package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidestrategy.topsidecollide.TsJumpBlockStrategy;
import view.ImageSet;

public class SpawnJump extends Spawn{
	public SpawnJump(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
	    this.collideType = DIFFERACTION;
	}
	
	public SpawnJump(CollideGameComponent CGC) {
		super(CGC);
		setTopCollideStrategy(new TsJumpBlockStrategy());
		setRegularJumpApply();
	}
	
	public Image getImage() {
		this.imageIcon = ImageSet.jump;
		return this.imageIcon;
	}

	public int getTypeCode() {
		return Spawn.SPAWNJUMP;
	}
}
