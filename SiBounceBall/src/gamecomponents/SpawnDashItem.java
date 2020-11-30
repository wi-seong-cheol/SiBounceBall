package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidehandler.DashItem;
import view.ImageSet;

public class SpawnDashItem extends Spawn{
	public SpawnDashItem(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
	    this.collideType = SAMEACTION;
	}

	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new DashItem(CGC);
	}

	public Image getImage() {
		this.imageIcon = ImageSet.dashItem;
		return this.imageIcon;
	}
}
