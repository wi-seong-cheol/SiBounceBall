package viewModel;

import model.Items;
import model.PhysicalQuantity;
import model.SceneInformation;
import model.UserInformation;

public class Information {
	public int userClick() {
		return SceneInformation.click;
	}
	
	public static String getID() {
		return SceneInformation.id;
	}
	
	public void setSceneNumber(int N) {
		SceneInformation.sceneNum = N;
	}
	
	public static int getSceneNumber() {
		return SceneInformation.sceneNum;
	}
	
	public void setHighLevel() {
		 SceneInformation.highestLevel++;
	}
	
	public static int getHighLevel() {
		return SceneInformation.highestLevel; 
	}
	
	public static int getLoginOrSignUp() {
		return UserInformation.loginOrSignUp;
	}
	
	public int setLoginOrSignUp(int N) {
		return UserInformation.loginOrSignUp = N;
	}
	
	public static int getLogin() {
		return SceneInformation.login;
	}
	
	public void setLogin(int N) {
		SceneInformation.login = N;
	}
	
	public static Boolean getInventory1() {
		return Items.inventory1;
	}
	
	public void setInventory1(Boolean state) {
		Items.inventory1 = state;
	}
	
	public static Boolean getInventory2() {
		return Items.inventory2;
	}
	
	public void setInventory2(Boolean state) {
		Items.inventory2 = state;
	}
	
	public void setClickState(int N) {
		SceneInformation.click = N;
	}
	
	public static int getX() {
		return PhysicalQuantity.X;
	}
	
	public static int getY() {
		return PhysicalQuantity.Y;
	}
	
	public static double getGravity() {
		return PhysicalQuantity.GRAVITY;
	}
}
