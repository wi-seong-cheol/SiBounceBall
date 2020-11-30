package scenes;

import java.util.ArrayList;
import gamecomponents.*;

public class MakeGameComponents {
	public static ArrayList<Spawn> living = new ArrayList<Spawn>();
	public static int wallType, thornType;
	
	public static void addBlock(Spawn obj) {
		MakeGameComponents.living.add(obj);
	}

	//switch문 해결
	public static void setBlockType(int sceneNum) {
		switch(sceneNum) {
		case 1: case 4:
			wallType=thornType=4;
			break;
		case 2: case 3:
			wallType=thornType=1;
			break;
		case 5:
			wallType=5;
			break;
		case 6:
			wallType=3;
			break;
		case 7:
			wallType=thornType=3;
			break;
		case 8:
			wallType=2;
			break;
		default:
			break;
		}
	}
	
	public static void makeScene(char ch, int i, int j) {
		ArrayList<Spawn> blocks = new ArrayList<Spawn>();
		switch(ch) {
		case '1':
			blocks.add(new SpawnWall(i, j, wallType));
			break;
		case '2':
			blocks.add(new SpawnJump(i, j));
			break;
		case '3':
			blocks.add(new SpawnThorn(i, j, thornType));
			break;
		case '4':
			blocks.add(new SpawnElectricity(i, j));
			break;
		case '5':
			blocks.add(new SpawnDashItem(i, j));
			break;
		case '6':
			blocks.add(new SpawnJumpItem(i, j));
			break;
		case '7':
			blocks.add(new SpawnStar(i, j));
			break;
		case '8':
			blocks.add(new SpawnBreakable(i, j));
			break;
		case '9':
			blocks.add(new SpawnMoveL(i, j));
			break;
		case 'A':
			blocks.add(new SpawnMoveR(i, j));
			break;
		default: //no block
			break;
		}
		for(Spawn elements: blocks) {
			addBlock(elements);
		}
	}
}
