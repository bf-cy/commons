/**********************************************************************************
 * 
 * @author lzy
* 2018年12月4日 下午6:04:05
 **********************************************************************************/
package lzy.commons.exception;

/**********************************************************************************
 * 
 * @author lzy 2018年12月4日 下午6:04:05
 **********************************************************************************/
public class CustomTransactionalException extends RuntimeException {

	/**********************************************************************************
	 * 
	 * @author lzy 2018年12月4日 下午6:04:10
	 **********************************************************************************/
	private static final long serialVersionUID = 1L;
	
	private String            errCode;
    private String            errMsg;

    public CustomTransactionalException() {
        super();
    }


    public CustomTransactionalException(String errMsg) {
        super(errMsg);
    }

    public CustomTransactionalException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CustomTransactionalException(Throwable cause) {
        super(cause);
    }

    public CustomTransactionalException(String errMsg, Throwable cause) {
        super(errMsg, cause);
    }

    public CustomTransactionalException(String errCode, String errMsg , Throwable cause) {
    	super(errCode + ":" + errMsg, cause);
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
