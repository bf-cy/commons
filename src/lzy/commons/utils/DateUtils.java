/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2018年12月11日 下午7:16:09
 **********************************************************************************/
package lzy.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2018年12月11日 下午7:16:09
 **********************************************************************************/
public class DateUtils {


	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private static SimpleDateFormat simpleDateFormatCST = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy", Locale.ENGLISH);
	
	/**********************************************************************************
	 * @Desc 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 * @author lzy
	 * @date 2018年12月11日 下午7:49:54
	 **********************************************************************************/
	public Date formatDate(String dateStr) throws ParseException {
		Date date = null;
		if(dateStr.toUpperCase().indexOf("CST")==20) {
			date = simpleDateFormatCST.parse(dateStr);
		}else {
			date = simpleDateFormat.parse(dateStr);
		}
		return date;
	}
	
	/**********************************************************************************
	 * @Desc 
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 * @author lzy
	 * @date 2018年12月11日 下午7:48:09
	 **********************************************************************************/
	public static Date formatDate(String dateStr,String pattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = dateFormat.parse(dateStr);
		return date;
	}

	/**********************************************************************************
	 * @Desc 指定时间，加上指定天数,根据b判断，如果date为空时，是否返回当天加上指定天数
	 * @param dayNum 指定天数
	 * @param date 指定时间 
	 * @param b true:如果指定时间为空，则自动获取当天时间；false:如果指定时间为空，则返回null
	 * @return 指定时间，加上指定天数后的日期
	 * @author lzy
	 * @date 2018年12月13日 上午9:47:57
	 **********************************************************************************/
	public static Date addDay(int dayNum,Date date,boolean b) {
		if(date==null) {
			if(b) {
				date=new Date();
			}else {
				return null;
			}
		}
		Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, dayNum);// +dayNum天
		return c.getTime();
	}
	/**********************************************************************************
	 * @Desc 指定时间，加上指定天数,如果指定时间为空，则自动获取当天时间
	 * @param dayNum 指定天数
	 * @param date 指定时间 ,如果指定时间为空，则自动获取当天时间
	 * @return 指定时间，加上指定天数后的日期
	 * @author lzy
	 * @date 2018年12月13日 上午9:47:57
	 **********************************************************************************/
	public static Date addDay(int dayNum,Date date) {
		return addDay(dayNum,date,true);
	}

	/**********************************************************************************
	 * @Desc 今天加上指定天数
	 * @param dayNum 指定天数
	 * @return 今天加上指定天数后的日期
	 * @author lzy
	 * @date 2018年12月13日 上午9:47:57
	 **********************************************************************************/
	public Date addDay(int dayNum) {
		return addDay(dayNum,null);
	}
}
