package state;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:15:28 
	*
*/
public abstract class Transition {

	private State fromState;
	
	private State toState;
	
	public Transition(State fromState, State toState) {
		this.fromState = fromState;
		this.toState = toState;
	}
	
	public abstract boolean meetCondition(Creature creature);
	
	
	public State fromState() {
		return fromState;
	}
	
	public State toState() {
		return toState;
	}
}
