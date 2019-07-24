/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年7月16日 下午5:37:06
 *****************************************************************************************************************************************************/
package lzy.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年7月16日 下午5:37:06
 *****************************************************************************************************************************************************/
public class LogUtils {
	
	public static Logger getLog(Object clazz) {
		Logger log = null;
		if(clazz instanceof Class<?>) {
			log = LoggerFactory.getLogger((Class<?>)clazz);
		}else if(clazz instanceof String) {
			log = LoggerFactory.getLogger((String)clazz);
		}else {
			throw new IllegalArgumentException("非法参数，日志实例仅支持：Class<?>或者String类型");
		}
		return log;
	}

}
