package state;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:06:24 
	*
*/
public interface State {

	
	void onEnter(Creature creature);
	
	void onExit(Creature creature);
	
	void execute(Creature creature);
}
