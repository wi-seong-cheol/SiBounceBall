package scenes;

import java.util.ArrayList;

import gamecomponents.*;

public class MakeGameComponents {
	public static ArrayList<Spawn> living = new ArrayList<Spawn>();

	public static synchronized void makeBall(int x, int y) {
		living.add(new SpawnBall(x, y));
	}
	public static synchronized void makeWall(int x, int y, int n) {
		living.add(new SpawnWall(x, y, n));  
	}
	public static synchronized void makeJump(int x, int y) {
		living.add(new SpawnJump(x, y));  
	}
	public static synchronized void makeThorn(int x, int y, int n) {
		living.add(new SpawnThorn(x, y, n));
	}
	public static synchronized void makeElectricity(int x, int y) {
		living.add(new SpawnElectricity(x, y));
	}
	public static synchronized void makeDashItem(int x, int y) {
		living.add(new SpawnDashItem(x, y));
	}
	public static synchronized void makeJumpItem(int x, int y) {
		living.add(new SpawnJumpItem(x, y));
	}
	public static synchronized void makeStar(int x, int y) {
		living.add(new SpawnStar(x, y));
	}
	public static synchronized void makeBreakable(int x, int y) {
		living.add(new SpawnBreakable(x, y));
	}
	public static synchronized void makeMoveL(int x, int y) {
		living.add(new SpawnMoveL(x, y));
	}
	public static synchronized void makeMoveR(int x, int y) {
		living.add(new SpawnMoveR(x, y));
	}
}
