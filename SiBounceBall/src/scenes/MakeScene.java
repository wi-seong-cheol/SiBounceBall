package scenes;

public class MakeScene extends MakeGameComponents{
  public void makeScene(char ch, int i, int j) {
	  switch(ch) {
		case '1':
			makeWall(i*30, j*30, 4); //벽 종류 임시
			break;
		case '2':
			makeJump(i*30, j*30);
			break;
		case '3':
			makeThorn(i*30, j*30, 1); //가시 종류 임시
			break;
		case '4':
			makeElectricity(i*30, j*30);
			break;
		case '5':
			makeDashItem(i*30, j*30);
			break;
		case '6':
			makeJumpItem(i*30, j*30);
			break;
		case '7':
			makeStar(i*30, j*30);
			break;
		case '8':
			makeBreakable(i*30, j*30);
			break;
		case '9':
			makeMoveL(i*30, j*30);
			break;
		case 'A':
			makeMoveR(i*30, j*30);
			break;
		default: //no block
			break;
		}
  }
}
