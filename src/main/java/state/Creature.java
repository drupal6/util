package state;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:07:28 
	*
*/
public class Creature {
	
	protected long hp;
	
	protected int attack;
	
	private Scene scene;
	
	public Creature(long hp, int attack) {
		this.hp = hp;
		this.attack = attack;
	}

	public long getHp() {
		return hp;
	}

	public void setHp(long hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
