/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年7月16日 下午5:37:06
 *****************************************************************************************************************************************************/
package lzy.commons.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年7月16日 下午5:37:06
 *****************************************************************************************************************************************************/
public class LogUtils {
	private static Map<String,Logger> loggerMap = new HashMap<String,Logger>();
	public static Logger getLog(Object clazz) {
		Logger log = null;
		if(clazz instanceof Class<?>) {
			String className = ((Class<?>) clazz).getName();
			log = loggerMap.get(className);
			if(log==null) {
				log = LoggerFactory.getLogger((Class<?>)clazz);
				loggerMap.put(className, log);
			}
		}else if(clazz instanceof String) {
			log = loggerMap.get((String)clazz);
			if(log==null) {
				log = LoggerFactory.getLogger((String)clazz);
				loggerMap.put((String)clazz, log);
			}
		}else {
			throw new IllegalArgumentException("非法参数，日志实例仅支持：Class<?>或者String类型");
		}
		return log;
	}

}
