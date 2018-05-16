package state;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:08:16 
	*
*/
public class Scene {
	private Player player;
	
	private Monster monster;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}
}
