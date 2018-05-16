package state;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:11:38 
	*
*/
public class Monster extends Creature {

	
	public Monster(long hp, int attack) {
		super(hp, attack);
	}
	
	public String toString() {
		return "monster hp=" + hp + " attack=" + attack;
	}
	
}
