/*****************************************************************************************************************************************************
 * @desc 
 * 
 * @author lzy
 * @date 2019年3月8日 下午6:07:04
 *****************************************************************************************************************************************************/
package lzy.commons.exception;

/*****************************************************************************************************************************************************
 * @desc 
 * 
 * @author lzy
 * @dateTime 2019年3月8日 下午6:07:04
 *****************************************************************************************************************************************************/
public class HelperException extends Throwable {

	/**********************************************************************************
	 * @Desc 
	 * @author lzy
	 * @date 2018年12月4日 下午6:04:10
	 **********************************************************************************/
	private static final long serialVersionUID = 1L;
	
	
	public HelperException(String message) {
		super(message);
	}

	public HelperException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public HelperException(Throwable cause) {
		super(cause);
	}
}