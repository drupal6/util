package state;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:08:51 
	*
*/
public class Player extends Creature{

	public Player(long hp, int attack) {
		super(hp, attack);
	}
	
	public String toString() {
		return "player hp=" + hp + " attack=" + attack;
	}
}
