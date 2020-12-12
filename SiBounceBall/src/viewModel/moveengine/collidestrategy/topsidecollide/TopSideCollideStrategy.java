package viewModel.moveengine.collidestrategy.topsidecollide;

import viewModel.moveengine.CollideGameComponent;

//상단 충돌 전략
// 1. 게임 리셋(가시), 2. 일반 점프(일반 블럭), 3. 일반 점프 후 블럭 삭제(일회성 블럭), 4. 좌우 이동(이동 블럭)
public interface TopSideCollideStrategy {
	public void topCollideHandler(CollideGameComponent CGC);
}
