package moveengine.collidestrategy.bottomsidecollide;

import moveengine.CollideGameComponent;

//하단 충돌 전략
// 1. 일반 충돌(일반 블럭, 일회성 블럭, 좌우 이동 블럭, 가시)
public interface BottomSideCollideStrategy {
	public void bottomCollideHandler(CollideGameComponent CGC);
}
