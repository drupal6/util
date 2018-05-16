package state.state.copy;

import state.Creature;
import state.State;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:21:53 
	*
*/
public class PatrolState implements State {

	public void onEnter(Creature creature) {

	}

	public void onExit(Creature creature) {

	}

	public void execute(Creature creature) {
		System.out.println("巡山头");
	}

}
