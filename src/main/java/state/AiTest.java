package state;

import state.state.AttackState;
import state.state.PatrolState;
import state.state.RunawayState;
import state.transition.Attack2PatrolTransition;
import state.transition.Attack2RunTransition;
import state.transition.Patrol2AttackTransition;
import state.transition.Run2PatrolTranstion;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月14日 下午4:49:05 
	*
*/
public class AiTest {

	public static void main(String[] args) {
		Player player = new Player(100, 15);
		Monster monster = new Monster(120, 10);
		
		Scene scene = new Scene();
		scene.setPlayer(player);
		scene.setMonster(monster);
		
		player.setScene(scene);
		monster.setScene(scene);
		
		State patrolState = new PatrolState();
		State attackState = new AttackState();
		State runawayState = new RunawayState();
		
		Transition transition1 = new Attack2PatrolTransition(attackState, patrolState);
		Transition transition2 = new Attack2RunTransition(attackState, runawayState);
		Transition transition3 = new Patrol2AttackTransition(patrolState, attackState);
		Transition transition4 = new Run2PatrolTranstion(runawayState, patrolState);
		
		FiniteStateMachine fsm = new FiniteStateMachine();  
        fsm.setInitState(patrolState);  
				
        fsm.addTransition(transition1);  
        fsm.addTransition(transition2);  
        fsm.addTransition(transition3);  
        fsm.addTransition(transition4);  
          
        while (true) {  
            fsm.enterFrame(player);  
        }  
	}
}
