package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidestrategy.allsidecollide.GetStarStrategy;
import view.ImageSet;

public class SpawnStar extends Spawn{
	public SpawnStar(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
	    this.collideType = SAMEACTION;
	}

	public SpawnStar(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new GetStarStrategy();
	}
	
	public Image getImage() {
		this.imageIcon = ImageSet.star;
		return this.imageIcon;
	}
	
	public int getTypeCode() {
		return Spawn.SPAWNSTAR;
	}
}
