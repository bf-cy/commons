/*****************************************************************************************************************************************************
 * 
 * 
 * @author lzy
* 2019年3月21日 下午6:16:46
 *****************************************************************************************************************************************************/
package lzy.commons.utils.time;

import java.text.SimpleDateFormat;
import java.util.Date;

/*****************************************************************************************************************************************************
 * 
 * 
 * @author lzy
* 2019年3月21日 下午6:16:46
 *****************************************************************************************************************************************************/
public class TimeUtils {
	
	/*****************************************************************************************************************************************************
	 * 获取当前时间字符串 
	 * @return 时间字符串--格式：1971-01-01 00:00:00
	 * @author lzy
* 2019年3月21日 下午6:18:00
	 *****************************************************************************************************************************************************/
	public static String currTime() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //精确到毫秒
		Date date = new Date();
		return fmt.format(date);
	}

	
	/*****************************************************************************************************************************************************
	 * 获取当前时间字符串
	 * @param pattern yyyy（年）MM（月）dd（日）HH（时）mm（分）ss（秒）SSS（毫秒）
	 * @return 时间字符串--格式：pattern
	 * @author lzy
* 2019年3月21日 下午6:20:19
	 *****************************************************************************************************************************************************/
	public static String currTime(String pattern) {
		SimpleDateFormat fmt = new SimpleDateFormat(pattern); //精确到毫秒
		Date date = new Date();
		return fmt.format(date);
	}

}
