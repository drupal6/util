package event.event;

import event.EventType;
import event.GameEvent;

/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月16日 下午2:06:43 
	*
*/
public abstract class PlayerEvent extends GameEvent{

	private final long playerId;
	
	public PlayerEvent(EventType type, long playerId) {
		super(type);
		this.playerId = playerId;
	}

	public long getPlayerId() {
		return playerId;
	}
}
