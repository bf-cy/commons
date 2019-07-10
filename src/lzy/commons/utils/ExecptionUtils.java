/*****************************************************************************************************************************************************
 * @desc 
 * 
 * @author lzy
 * @date 2019年7月8日 下午3:49:01
 *****************************************************************************************************************************************************/
package lzy.commons.utils;

import lzy.commons.exception.UtilException;

/*****************************************************************************************************************************************************
 * @desc 
 * 
 * @author lzy
 * @dateTime 2019年7月8日 下午3:49:01
 *****************************************************************************************************************************************************/
public class ExecptionUtils {
	
	public static UtilException a(Exception e,String errCode,String errMsg) {
		if(e instanceof UtilException)
			return new UtilException(errCode, ((UtilException) e).getErrMsg(), e);
		else
			return new UtilException(errMsg, errMsg, e);
	}

}
