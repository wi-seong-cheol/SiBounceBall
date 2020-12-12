package viewModel.gamecomponents;

import java.awt.Image;

import view.ImageSet;
import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.collidehandler.Star;

public class SpawnStar extends Spawn{
	public SpawnStar() {}
	
	public SpawnStar(int x, int y) {
		this.x = x; //<<<<<<< HEAD
		this.y = y;
		this.type = 1;
		this.length = 30;
	    this.collideType = SAMEACTION;
	}
	
	public static SpawnStar newInstance() {
		return new SpawnStar();
	}
	
	public SpawnStar getInstance(int x, int y, int n) {
		return new SpawnStar(x, y);
	}
	
	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new Star(CGC);
	}
	
	public Image getImage() {
		this.imageIcon = ImageSet.star;
		return this.imageIcon;
	}
}
