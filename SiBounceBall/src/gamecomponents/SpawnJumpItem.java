package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidehandler.JumpItem;
import view.ImageSet;

public class SpawnJumpItem extends Spawn{
	public SpawnJumpItem(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = SAMEACTION;
	}
	
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new JumpItem(CGC);
	}

	public Image getImage() {
		this.imageIcon = ImageSet.jumpItem;
		return this.imageIcon;
	}

}