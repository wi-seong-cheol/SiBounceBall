package gamecomponents;

import java.awt.Image;

import moveengine.CollideGameComponent;
import moveengine.collidehandler.BreakableBlock;
import view.ImageSet;

public class SpawnBreakable extends Spawn{
	
	public SpawnBreakable() {}
	
	public SpawnBreakable(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 24;
		this.collideType = DIFFERACTION;
	}
	
	public static SpawnBreakable newInstance() {
		return new SpawnBreakable();
	}
	
	public SpawnBreakable getInstance(int x, int y, int n) {
		return new SpawnBreakable(x, y);
	}
	
	public Image getImage() {
		this.imageIcon = ImageSet.breakable;
		return this.imageIcon;
	}
	
	public void setCollideHandler(CollideGameComponent CGC) {
		collideHandler = new BreakableBlock(CGC);
	}
}
