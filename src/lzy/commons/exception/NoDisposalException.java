/**********************************************************************************
 * 
 * @author lzy
* 2018年12月4日 下午6:04:05
 **********************************************************************************/
package lzy.commons.exception;

/**********************************************************************************
 * 不需要处理的异常
 * @author lzy
* 2018年12月4日 下午6:04:05
 **********************************************************************************/
public class NoDisposalException extends Throwable {
	

	/**********************************************************************************
	 * 
	 * @author lzy
* 2018年12月4日 下午6:04:10
	 **********************************************************************************/
	private static final long serialVersionUID = 1L;
	
	private String            errCode="NO_CODE";
    private String            errMsg;

    public NoDisposalException() {
        super();
    }


    public NoDisposalException(String errMsg) {
        super(errMsg);
    }

    public NoDisposalException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public NoDisposalException(Throwable cause) {
        super(cause);
    }

    public NoDisposalException(String errMsg, Throwable cause) {
        super(errMsg, cause);
    }

    public NoDisposalException(String errCode, String errMsg , Throwable cause) {
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
