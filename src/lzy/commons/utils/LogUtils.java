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
	
	public static Logger getLog(Class<?> clazz) {
		Logger log = LoggerFactory.getLogger(clazz);
		return log;
	}

}
