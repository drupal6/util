package state.transition;

import state.Creature;
import state.Player;
import state.State;
import state.Transition;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:26:32 
	*
*/
public class Attack2PatrolTransition extends Transition {

	public Attack2PatrolTransition(State fromState, State toState) {
		super(fromState, toState);
	}

	@Override
	public boolean meetCondition(Creature creature) {
		Player player = (Player) creature;
		return player.getScene().getMonster().getHp() == 0;
	}

}
