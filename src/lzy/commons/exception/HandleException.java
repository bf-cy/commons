/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2018年12月4日 下午6:04:05
 **********************************************************************************/
package lzy.commons.exception;

/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2018年12月4日 下午6:04:05
 **********************************************************************************/
public class HandleException extends Exception {

	/**********************************************************************************
	 * @Desc 
	 * @author lzy
	 * @date 2018年12月4日 下午6:04:10
	 **********************************************************************************/
	private static final long serialVersionUID = 1L;
	
	
	public HandleException(String message) {
		super(message);
	}

	public HandleException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public HandleException(Throwable cause) {
		super(cause);
	}
	

}
