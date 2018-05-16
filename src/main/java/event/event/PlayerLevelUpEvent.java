package event.event;

import event.EventType;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月16日 下午3:13:23 
	*
*/
public class PlayerLevelUpEvent extends PlayerEvent {
	
	private final int level;

	public PlayerLevelUpEvent(EventType type, long playerId, int level) {
		super(type, playerId);
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}
