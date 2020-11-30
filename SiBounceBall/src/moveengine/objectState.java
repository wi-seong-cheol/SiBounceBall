package moveengine;

import gamecomponents.*;
public class objectState {

	static final int SPAWNBREAKABLE = 1;
	static final int SPAWNDASHITEM = 2;
	static final int SPAWNELECTRICITY = 3;
	static final int SPAWNJUMP = 4;
	static final int SPAWNJUMPITEM = 5;
	static final int SPAWNMOVEL = 6;
	static final int SPAWNMOVER = 7;
	static final int SPAWNSTAR = 8;
	static final int SPAWNTHORN = 9;
	static final int SPAWNWALL = 10;
	
	public static Spawn setType(int type,CollideGameComponent CGC) {
		switch(type) {
			case SPAWNBREAKABLE:
				return new SpawnBreakable(CGC);
			case SPAWNDASHITEM:
				return new SpawnDashItem(CGC);
			case SPAWNELECTRICITY:
				return new SpawnElectricity(CGC);
			case SPAWNJUMP:
				return new SpawnJump(CGC);
			case SPAWNJUMPITEM:
				return new SpawnJumpItem(CGC);
			case SPAWNMOVEL:
				return new SpawnMoveL(CGC);
			case SPAWNMOVER:
				return new SpawnMoveR(CGC);
			case SPAWNSTAR:
				return new SpawnStar(CGC);
			case SPAWNTHORN:
				return new SpawnThorn(CGC);
			case SPAWNWALL:
				return new SpawnWall(CGC);
			default: 
				throw new IllegalArgumentException();
		}
	}
}
