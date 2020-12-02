package view;

import java.util.ArrayList;
import gamecomponents.*;

public class MakeGameComponents {
	public static ArrayList<Spawn> living = new ArrayList<Spawn>();
	public static int blockImage;
	private static String[] blockTypeStr = {"Wall", "Jump", "Thorn", "Electricity", "DashItem", "JumpItem", "Star", "Breakable", "MoveL", "MoveR"};
	private static String str = "gamecomponents.Spawn";
	
	public static void addBlock(Spawn obj) {
		MakeGameComponents.living.add(obj);
	}

	//switch臾� �빐寃�
	public static void setBlockType(int sceneNum) {
		switch(sceneNum) {
		case 1: case 4:
			blockImage=4;
			break;
		case 2: case 3:
			blockImage=1;
			break;
		case 5:
			blockImage=5;
			break;
		case 6:
			blockImage=3;
			break;
		case 7:
			blockImage=3;
			break;
		case 8:
			blockImage=2;
			break;
		default:
			break;
		}
	}
	
	public static void makeScene(char ch, int i, int j) {
		ArrayList<Spawn> blocks = new ArrayList<Spawn>();
		Class c;
		Spawn s;
		int blockType = 0;
		
		if (ch == '0') return;
		else if(ch == 'A') blockType = 9;
		else blockType = ch - '0' - 1;
		
		try {
			c = Class.forName(str + blockTypeStr[blockType]);
			s  = (Spawn)c.newInstance();
			
			blocks.add(s.getInstance(i, j, blockImage));

			for(Spawn elements: blocks) {
				addBlock(elements);
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}