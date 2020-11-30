package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidestrategy.allsidecollide.GetDashItemStrategy;
import view.ImageSet;

public class SpawnDashItem extends Spawn{
	public SpawnDashItem(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
	    this.collideType = SAMEACTION;
	}

	public SpawnDashItem(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new GetDashItemStrategy();
	}

	public Image getImage() {
		this.imageIcon = ImageSet.dashItem;
		return this.imageIcon;
	}

	public int getTypeCode() {
		return Spawn.SPAWNDASHITEM;
	}
	
}
