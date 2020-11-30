package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidestrategy.allsidecollide.GetJumpItemStrategy;
import view.ImageSet;

public class SpawnJumpItem extends Spawn{
	public SpawnJumpItem(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = SAMEACTION;
	}
	
	public SpawnJumpItem(CollideGameComponent CGC) {
		super(CGC);
		allCollide = new GetJumpItemStrategy();
	}

	public Image getImage() {
		this.imageIcon = ImageSet.jumpItem;
		return this.imageIcon;
	}

	public int getTypeCode() {
		return Spawn.SPAWNJUMPITEM;
	}
}