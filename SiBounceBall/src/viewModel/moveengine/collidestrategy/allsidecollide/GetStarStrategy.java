package viewModel.moveengine.collidestrategy.allsidecollide;

import view.MakeMainScene;
import viewModel.moveengine.CollideGameComponent;

public class GetStarStrategy implements AllSideCollideStrategy{
	public void allCollideHandler(CollideGameComponent CGC) {
		CGC.deleteObject();
		if (MakeMainScene.star == 1) {
			try {
				Thread.sleep(650);
			} catch (Exception e) {
			}
			CGC.ball.updatePos(900, 1000);
		}
		MakeMainScene.star--;
	}
}
