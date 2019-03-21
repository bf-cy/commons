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
public class HandleException extends Throwable {

	/**********************************************************************************
	 * @Desc 
	 * @author lzy
	 * @date 2018年12月4日 下午6:04:10
	 **********************************************************************************/
	private static final long serialVersionUID = 1L;
	
	private String            errCode;
    private String            errMsg;

    public HandleException() {
        super();
    }

    public HandleException(String message, Throwable cause) {
        super(message, cause);
    }

    public HandleException(String message) {
        super(message);
    }

    public HandleException(Throwable cause) {
        super(cause);
    }

    public HandleException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
	
	

}
