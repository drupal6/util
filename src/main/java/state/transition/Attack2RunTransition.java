package state.transition;

import state.Creature;
import state.Player;
import state.Scene;
import state.State;
import state.Transition;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:25:45 
	*
*/
public class Attack2RunTransition extends Transition {

	public Attack2RunTransition(State fromState, State toState) {
		super(fromState, toState);
	}

	@Override
	public boolean meetCondition(Creature creature) {
		Player player = (Player) creature;
		return player.getHp() < 50 || Math.random() < 0.4;
	}
}
