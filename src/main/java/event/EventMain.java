package event;

import event.event.PlayerLevelUpEvent;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月16日 下午3:23:08 
	*
*/
public class EventMain {

	public static void main(String[] args) {
		ListenerManager.INSTANCE.initalize();
		EventDispatcher.getInstance().fireEvent(new PlayerLevelUpEvent(EventType.LEVEL_UP, 1, 1));
	}
	
}
