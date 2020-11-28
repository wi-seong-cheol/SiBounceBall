package moveengine.leftsidecollide;

import moveengine.CollideGameComponent;

//좌측 충돌 전략
// 1. 일반 점프(일반 블럭, 일회성 블럭, 좌우 이동 블럭, 가시)
public interface LeftSideCollideStrategy {
	public void leftCollideHandler(CollideGameComponent CGC);
}
