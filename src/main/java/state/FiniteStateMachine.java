package state;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:36:44 
	*
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FiniteStateMachine {

	private State initState;
	
	private State currState;
	
	private Map<State, List<Transition>> state2Transition = new HashMap<State, List<Transition>>();
	
	private volatile boolean running = true;
	
	private long freeZeTimeOut;
	
	public void addTransition(Transition transition) {
		List<Transition> ts = state2Transition.get(transition.fromState());
		if(ts == null) {
			ts = new ArrayList<>();
			state2Transition.put(transition.fromState(), ts);
		}
		ts.add(transition);
	}
	
	public State getInitState() {
		return initState;
	}
	
	public void setInitState(State state) {
		this.initState = state;
	}
	
	public void enterFrame(Creature creature) {
		if(this.currState == null) {
			this.currState = this.initState;
			this.currState.onEnter(creature);
		}
		
		Set<String> passed = new HashSet<>();
		String className = this.currState.getClass().getName();
		
		for(;;) {
			if(!running) {
				if(freeZeTimeOut > 0 && System.currentTimeMillis() > freeZeTimeOut) {
					running = true;
				} else {
					break;
				}
			}
			this.currState.execute(creature);
			if(passed.contains(className)) {
				break;
			}
			passed.add(className);
			List<Transition> ts = state2Transition.get(this.currState);
			for(Transition transition : ts) {
				if(transition.meetCondition(creature)) {
					this.currState.onExit(creature);
					this.currState = transition.toState();
					this.currState.onEnter(creature);
				}
			}
		}
	}
	
	public void freeze(long timeout) {
		this.freeZeTimeOut = System.currentTimeMillis() + timeout;
	}
}
