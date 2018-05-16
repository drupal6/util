package event;
/** 
	*
	* @author Gene
	* @version 创建时间:2018年5月16日 下午2:10:33 
	*
*/

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import event.listener.SkillListener;
import event.util.ClassScanner;

public enum ListenerManager {
	
	INSTANCE;
	
	private Map<String, Method> map = new HashMap<>();
	
	public void initalize() {
		Set<Class<?>> clazzs = ClassScanner.getClasses(SkillListener.class.getPackage());
		for(Class<?> clazz : clazzs) {
			if(clazz.getAnnotation(Listener.class) == null) {
				continue;
			} 
			try {
				Object handler = clazz.newInstance();
				Method[] methods = clazz.getDeclaredMethods();
				for(Method method : methods) {
					EventHandler mapperAnnotation = method.getAnnotation(EventHandler.class);
					if(mapperAnnotation != null) {
						EventType[] eventTypes = mapperAnnotation.value();
						for(EventType eventType : eventTypes) {
							EventDispatcher.getInstance().registerEvent(eventType, handler);
							map.put(getKey(handler, eventType), method);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fireEvent(Object handler, GameEvent event) {
		try {
			Method method = map.get(getKey(handler, event.getType()));
			method.invoke(handler, event);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getKey(Object handler, EventType eventType) {  
        return handler.getClass().getName() + "-" + eventType.toString();  
    }  
}
