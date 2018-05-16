package state.state;

import state.Creature;
import state.Monster;
import state.Player;
import state.Scene;
import state.State;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:20:35 
	*
*/
public class AttackState implements State {

	public void onEnter(Creature creature) {
		// TODO Auto-generated method stub

	}

	public void onExit(Creature creature) {
		// TODO Auto-generated method stub

	}

	public void execute(Creature creature) {
		Player player = (Player) creature;
		Scene scene = player.getScene();
		Monster monster = scene.getMonster();
		player.setHp(player.getHp() - monster.getAttack());
		monster.setHp(monster.getHp() - player.getAttack());
		System.err.println("邂逅敌人，快使用双截棍，哼哼哈兮。"  + "我方血量["+ player.getHp() + "]" + "敌方血量["+ monster.getHp() + "]"); 
	}

}
