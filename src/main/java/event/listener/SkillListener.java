package event.listener;

import event.EventHandler;
import event.EventType;
import event.Listener;
import event.event.PlayerLevelUpEvent;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月16日 下午3:07:58 
	*
*/
@Listener
public class SkillListener {

	@EventHandler(value=EventType.LEVEL_UP)
	public void onPlayerLevelUp(PlayerLevelUpEvent levelUpEvent) {
		System.out.println(getClass().getSimpleName() + "捕捉到时间" + levelUpEvent);
	}
}
