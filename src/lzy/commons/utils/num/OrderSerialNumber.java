/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年11月14日 下午3:13:02
 *****************************************************************************************************************************************************/
package lzy.commons.utils.num;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年11月14日 下午3:13:02
 *****************************************************************************************************************************************************/
public class OrderSerialNumber extends SerialNumber {

	protected final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	protected DecimalFormat df = null;
	public OrderSerialNumber(int width) {
		if (width < 1) {
			throw new IllegalArgumentException(
					"Parameter length must be great than 1!");
		}
		char[] chs = new char[width];
		for (int i = 0; i < width; i++) {
			chs[i] = '0';
		}
		df = new DecimalFormat(new String(chs));
	}

	/*****************************************************************************************************************************************************
	 * 方法未完成
	 * (non-Javadoc)
	 * 
	 * @see lzy.commons.utils.num.SerialNumber#process()
	 * @author lzy 2019年11月14日 下午3:13:02
	 *****************************************************************************************************************************************************/
	@Override
	protected String process() {
		Date date = new Date();
		int n = 4;
		return format(date) + format(n);
	}

	protected String format(Date date) {
		return sdf.format(date);
	}

	protected String format(int num) {
		return df.format(num);
	}
}
	
