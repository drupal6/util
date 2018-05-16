package event;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月16日 下午2:09:35 
	*
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;

public class EventDispatcher {
	
	private static EventDispatcher instance = new EventDispatcher();
	
	public EventDispatcher() {
		new NameableThreadFactory("event-dispatcher").newThread(new EventWorker()).start();
	}
	
	public static EventDispatcher getInstance() {
		return instance;
	}
	
	private final Map<EventType, Set<Object>> observers = new HashMap<>();
	
	private LinkedBlockingQueue<GameEvent> eventQueue = new LinkedBlockingQueue<>();
	
	public void registerEvent(EventType type, Object Listener) {
		Set<Object> listeners = observers.get(type);
		if(listeners == null) {
			listeners = new HashSet<>();
			observers.put(type, listeners);
		}
		listeners.add(Listener);
	}
	
	public void fireEvent(GameEvent event) {
		if(event == null) {
			throw new NullPointerException("event cannot be null");
		}
		if(event.isSynchronized()) {
			triggerEvent(event);
		} else {
			eventQueue.add(event);
		}
	}
	
	public void triggerEvent(GameEvent event) {
		EventType type = event.getType();
		Set<Object> listeners = observers.get(type);
		if(listeners != null) {
			for(Object listener : listeners) {
				ListenerManager.INSTANCE.fireEvent(listener, event);
			}
		}
	}
	
	private class EventWorker implements Runnable {

		@Override
		public void run() {
			while(true) {
				try {
					GameEvent event = eventQueue.take();
					triggerEvent(event);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private class NameableThreadFactory implements ThreadFactory {
		private String name;
		
		public NameableThreadFactory(String name) {
			this.name = name;
		}
		
		@Override
		public Thread newThread(Runnable r) {
			return new Thread(r, name);
		}
		
	}
}
