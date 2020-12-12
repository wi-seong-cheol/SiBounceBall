package viewModel.gamecomponents;

import java.awt.Image;

import view.ImageSet;
import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.collidehandler.HorizontalMoveR;

public class SpawnMoveR extends Spawn{
	public SpawnMoveR() {}
	
	public SpawnMoveR(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
		this.collideType = DIFFERACTION;
	}
	
	public static SpawnMoveR newInstance() {
		return new SpawnMoveR();
	}
	
	public SpawnMoveR getInstance(int x, int y, int n) {
		return new SpawnMoveR(x, y);
	}
	
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new HorizontalMoveR(CGC);
	}
	
	public Image getImage() {
		this.imageIcon = ImageSet.moveR;
		return this.imageIcon;
	}
}
