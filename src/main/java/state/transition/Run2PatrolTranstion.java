package state.transition;

import state.Creature;
import state.State;
import state.Transition;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:27:34 
	*
*/
public class Run2PatrolTranstion extends Transition {

	public Run2PatrolTranstion(State fromState, State toState) {
		super(fromState, toState);
	}

	@Override
	public boolean meetCondition(Creature creature) {
		return true;
	}

}
