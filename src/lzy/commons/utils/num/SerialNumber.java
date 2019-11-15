/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年11月14日 下午3:04:32
 *****************************************************************************************************************************************************/
package lzy.commons.utils.num;

/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年11月14日 下午3:04:32
 *****************************************************************************************************************************************************/
public abstract class SerialNumber {

	public synchronized String getSerialNumber() {
		return process();
	}
	protected abstract String process();
}
