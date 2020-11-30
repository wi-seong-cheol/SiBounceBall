package viewModel;

import model.SceneInformation;
import model.UserInformation;
import view.MakeUI;

public class UserInput {
	
	public static void userInput() {}

	public void signUpInput() {
		UserInformation.nickName = MakeUI.nickNameField.getText();
		UserInformation.id = MakeUI.idField.getText();
		UserInformation.pw = MakeUI.pwField.getText();
	}
	
	public void loginInput() {
		UserInformation.id = MakeUI.idField.getText();
		UserInformation.pw = MakeUI.pwField.getText();
	}

	public void login() { 
		SceneInformation.id = UserInformation.id;
	}
}
