package state.transition;

import state.Creature;
import state.State;
import state.Transition;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:28:14 
	*
*/
public class Patrol2AttackTransition extends Transition {

	public Patrol2AttackTransition(State fromState, State toState) {
		super(fromState, toState);
	}

	@Override
	public boolean meetCondition(Creature creature) {
		return Math.random() < 0.5;
	}

}
