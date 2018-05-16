package event;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月16日 下午2:01:19 
	*
*/
public abstract class GameEvent {
	
	private final EventType type;
	private long createTime;
	
	public GameEvent(EventType type) {
		this.type = type;
		this.createTime = System.currentTimeMillis();
	}

	public EventType getType() {
		return type;
	}

	public long getCreateTime() {
		return createTime;
	}
	
	public boolean isSynchronized() {
		return true;
	}
}
