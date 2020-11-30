package optimizedSBB;

import view.Animation;
import view.MakeMainScene;
import view.MakeUI;
import view.StageFrame;
import moveengine.MoveEngine;

public class SBBMain {
	public static boolean isRunning = true;
	private static Thread moveEngine = new MoveEngine();
	private static Thread makeMainScene = new MakeMainScene();

	public static void main(String[] args)
	{
		// Initialize some things.
		StageFrame stageFrame = new StageFrame();
		Animation animation = new Animation();
		MakeUI makeUI = new MakeUI();
		stageFrame.initializeJFrame();
		makeUI.MakeScene();
		moveEngine.start();
		makeMainScene.start();
		animation.runAnimation();
	}
}
