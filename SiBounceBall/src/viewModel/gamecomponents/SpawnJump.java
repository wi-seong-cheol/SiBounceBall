package viewModel.gamecomponents;

import java.awt.Image;

import view.ImageSet;
import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.collidehandler.JumpBlock;

public class SpawnJump extends Spawn{
	public SpawnJump() {}
	
	public SpawnJump(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
	    this.collideType = DIFFERACTION;
	}
	
	public static SpawnJump newInstance() {
		return new SpawnJump();
	}
	
	public SpawnJump getInstance(int x, int y, int n) {
		return new SpawnJump(x, y);
	}
	
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new JumpBlock(CGC);
	}
	
	public Image getImage() {
		this.imageIcon = ImageSet.jump;
		return this.imageIcon;
	}
}
