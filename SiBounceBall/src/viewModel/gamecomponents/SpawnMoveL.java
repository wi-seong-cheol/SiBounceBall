package viewModel.gamecomponents;

import java.awt.Image;

import view.ImageSet;
import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.collidehandler.HorizontalMoveL;

public class SpawnMoveL extends Spawn{
	public SpawnMoveL() {}
	
	public SpawnMoveL(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = DIFFERACTION;
	}
	
	public static SpawnMoveL newInstance() {
		return new SpawnMoveL();
	}
	
	public SpawnMoveL getInstance(int x, int y, int n) {
		return new SpawnMoveL(x, y);
	}
	
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new HorizontalMoveL(CGC);
	}

	public Image getImage() {
		this.imageIcon = ImageSet.moveL;
		return this.imageIcon;
	}
	
}
