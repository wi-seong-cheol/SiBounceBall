package moveengine.collidestrategy.allsidecollide;

import moveengine.CollideGameComponent;
import scenes.MakeMainScene;

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
