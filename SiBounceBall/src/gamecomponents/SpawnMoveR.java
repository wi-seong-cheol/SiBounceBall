package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidehandler.HorizontalMoveR;
import view.ImageSet;

public class SpawnMoveR extends Spawn{
	public SpawnMoveR(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = DIFFERACTION;
	}
	
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new HorizontalMoveR(CGC);
	}
	
	public Image getImage() {
		this.imageIcon = ImageSet.moveR;
		return this.imageIcon;
	}
}
