package viewModel.gamecomponents;

import java.awt.Image;

import view.ImageSet;
import viewModel.moveengine.CollideGameComponent;
import viewModel.moveengine.collidehandler.DashItem;

public class SpawnDashItem extends Spawn{
	public SpawnDashItem() {}
	
	public SpawnDashItem(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = 1;
		this.length = 30;
	    this.collideType = SAMEACTION;
	}
	
	public static SpawnDashItem newInstance() {
		return new SpawnDashItem();
	}
	
	public SpawnDashItem getInstance(int x, int y, int n) {
		return new SpawnDashItem(x, y);
	}

	public void setCollideHandler(CollideGameComponent CGC) { 
		this.collideHandler = new DashItem(CGC);
	}

	public Image getImage() {
		this.imageIcon = ImageSet.dashItem;
		return this.imageIcon;
	}
}
