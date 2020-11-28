package moveengine.allsidecollide;

import moveengine.CollideGameComponent;

//전방향 충돌 전략
// 아이템,별 획득,리셋(전기)
public interface AllSideCollideStrategy {
	public void allCollideHandler(CollideGameComponent CGC);
}
