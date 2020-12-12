package view;

import java.util.ArrayList;

import viewModel.gamecomponents.*;

public class MakeGameComponents {
	public static ArrayList<Spawn> living = new ArrayList<Spawn>();
	public static int blockImage;
	private static String[] blockTypeStr = {"Wall", "Jump", "Thorn", "Electricity", "DashItem", "JumpItem", "Star", "Breakable", "MoveL", "MoveR"};
	private static String str = "viewModel.gamecomponents.Spawn";
	static final int STAGE1=1;
	static final int STAGE2=2;
	static final int STAGE3=3;
	static final int STAGE4=4;
	static final int STAGE5=5;
	static final int STAGE6=6;
	static final int STAGE7=7;
	static final int STAGE8=8;
	
	public static void addBlock(Spawn obj) {
		MakeGameComponents.living.add(obj);
	}
	
	public static void setBlockType(int stage) {
	      switch(stage) {
	      case STAGE1: case STAGE4:
	         blockImage=4;
	         break;
	      case STAGE2: case STAGE3:
	         blockImage=1;
	         break;
	      case STAGE5:
	         blockImage=5;
	         break;
	      case STAGE6: case STAGE7:
	         blockImage=3;
	         break;
	      case STAGE8:
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