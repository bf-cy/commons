/**********************************************************************************
 * 
 * @author lzy 2018年12月11日 下午7:16:09
 **********************************************************************************/
package lzy.commons.utils.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import lzy.commons.exception.UtilException;

/**********************************************************************************
 * 
 * @author lzy 2018年12月11日 下午7:16:09
 **********************************************************************************/
public class DateUtils {


	/*****************************************************************************************************************************************************
	 * 年-月-日 时:分:秒（24小时制）：yyyy-MM-dd HH:mm:ss
	 *****************************************************************************************************************************************************/
	public static SimpleDateFormat YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/*****************************************************************************************************************************************************
	 * 年-月-日：yyyy-MM-dd
	 *****************************************************************************************************************************************************/
	public static SimpleDateFormat YEAR_MONTH_DAY = new SimpleDateFormat("yyyy-MM-dd");
	/*****************************************************************************************************************************************************
	 * 年-月：yyyy-MM
	 *****************************************************************************************************************************************************/
	public static SimpleDateFormat YEAR_MONTH = new SimpleDateFormat("yyyy-MM");
	/*****************************************************************************************************************************************************
	 * 年-月-日：yyyy
	 *****************************************************************************************************************************************************/
	public static SimpleDateFormat YEAR = new SimpleDateFormat("yyyy");
	/*****************************************************************************************************************************************************
	 * 英国格式： EEE MMM dd hh:mm:ss zzz yyyy
	 *****************************************************************************************************************************************************/
	public static SimpleDateFormat CST = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy", Locale.ENGLISH);
	
	/**********************************************************************************
	 * 将时间字符串转换为时间，当前方法不完善，以后遇到慢慢扩展，目前仅支持两种格式
		yyyy-MM-dd hh:mm:ss
		"EEE MMM dd hh:mm:ss zzz yyyy", Locale.ENGLISH
	 * @param dateStr 日期字符串
	 * @return 返回日期 字符串为空时返回空值
	 * @author lzy 2018年12月11日 下午7:49:54
	 **********************************************************************************/
	public static Date parseString(String dateStr) {
		try {
			Date date = null;
			if(StringUtils.isNotBlank(dateStr)) {
				if(dateStr.toUpperCase().indexOf("CST")==20) {
					date = CST.parse(dateStr);
				}else {
					int length = dateStr.trim().length();
					int indexOf = dateStr.indexOf("-");
					if(length>10)
						date = YEAR_MONTH_DAY_HOUR_MINUTE_SECOND.parse(dateStr);
					else if(length<=10 && length>7 && indexOf>0) {
						date = YEAR_MONTH_DAY.parse(dateStr);
					}else if(length<=7 && length>4 && indexOf>0) {
						date = YEAR_MONTH.parse(dateStr);
					}else if(length==4) {
						date = YEAR.parse(dateStr);
					}else {
						throw new UtilException("DATE_FORMAT_ERROR", "时间字符串格式化异常");
					}
				}
			}
			return date;
		} catch (Exception e) {
			throw new UtilException("DATE_FORMAT_ERROR", "时间字符串格式化异常", e);
		}
	}
	
	/**********************************************************************************
	 * 将指定时间字符串格式化为指定格式
	 * @param dateStr 是按字符串
	 * @param pattern 时间格式
	 * @return 返回日期
	 * @author lzy 2018年12月11日 下午7:48:09
	 **********************************************************************************/
	public static Date parseString(String dateStr,String pattern) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			Date date = dateFormat.parse(dateStr);
			return date;
		} catch (Exception e) {
			throw new UtilException("DATE_FORMAT_ERROR", "时间字符串格式化异常", e);
		}
	}

	/**********************************************************************************
	 * 指定时间，加上指定天数,根据b判断，如果date为空时，是否返回当天加上指定天数
	 * @param dayNum 指定天数
	 * @param date 指定时间 
	 * @param b true:如果指定时间为空，则自动获取当天时间；false:如果指定时间为空，则返回null
	 * @return 指定时间，加上指定天数后的日期
	 * @author lzy 2018年12月13日 上午9:47:57
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
	 * 指定时间，加上指定天数,如果指定时间为空，则自动获取当天时间
	 * @param dayNum 指定天数
	 * @param date 指定时间 ,如果指定时间为空，则自动获取当天时间
	 * @return 指定时间，加上指定天数后的日期
	 * @author lzy 2018年12月13日 上午9:47:57
	 **********************************************************************************/
	public static Date addDay(int dayNum,Date date) {
		return addDay(dayNum,date,true);
	}

	/**********************************************************************************
	 * 今天加上指定天数
	 * @param dayNum 指定天数
	 * @return 今天加上指定天数后的日期
	 * @author lzy 2018年12月13日 上午9:47:57
	 **********************************************************************************/
	public Date addDay(int dayNum) {
		return addDay(dayNum,null);
	}
	
	

	/*****************************************************************************************************************************************************
	 * 获取指定时间所在的月一共有多少天
	 * @param date 日期
	 * @return 指定日期所在月份有天数
	 * @author lzy 2019年7月8日 下午4:03:33
	 *****************************************************************************************************************************************************/
	public static int specifyNumDayMonth(Date date) {
		try {
			Calendar c= Calendar.getInstance();
			c.setTime(date);
			int n=c.getActualMaximum(Calendar.DAY_OF_MONTH);
			return n;
		} catch (Exception e) {
			throw new UtilException("DATE_FORMAT_ERROR", "时间字符串格式化异常", e);
		}
	}
	
	/*****************************************************************************************************************************************************
	 * 获取指定时间所在的月一共有多少天
	 * @param dateStr 日期字符串
	 * @return 指定日期所在月份有天数
	 * @author lzy 2019年7月8日 下午4:03:29
	 *****************************************************************************************************************************************************/
	public static int specifyNumDayMonth(String dateStr) {
		try {
			Date date = parseString(dateStr);
			Calendar c= Calendar.getInstance();
			c.setTime(date);
			int n=c.getActualMaximum(Calendar.DAY_OF_MONTH);
			return n;
		} catch (Exception e) {
			throw new UtilException("DATE_FORMAT_ERROR", "时间字符串格式化异常", e);
		}
	}
	
//	public static void main(String[] args) {
//		int specifyNumDayMonth = specifyNumDayMonth("2019-04");
//		System.out.println(specifyNumDayMonth);
//		
//	}

	/*****************************************************************************************************************************************************
	 * 将指定日期转换为字符串
	 * @param date 日期
	 * @return 日期字符串，格式为：2019-01-01 14:23:40
	 * @author lzy 2019年7月8日 下午6:07:47
	 *****************************************************************************************************************************************************/
	public static String formatDate(Date date) {
		String format = YEAR_MONTH_DAY_HOUR_MINUTE_SECOND.format(date);
		return format;
	}
	/*****************************************************************************************************************************************************
	 * 将指定日期转换为字符串
	 * @param date 日期
	 * @param pattern 日期格式
	 * @return 日期字符串
	 * @author lzy 2019年7月8日 下午6:07:47
	 *****************************************************************************************************************************************************/
	public static String formatDate(Date date,String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String format = simpleDateFormat.format(date);
		return format;
	}
	/*****************************************************************************************************************************************************
	 * 将指定日期转换为字符串
	 * @param date 日期
	 * @param simpleDateFormat 简单日期格式 
	 * @return 日期字符串
	 * @author lzy 2019年7月8日 下午6:07:47
	 *****************************************************************************************************************************************************/
	public static String formatDate(Date date,SimpleDateFormat simpleDateFormat) {
		String format = simpleDateFormat.format(date);
		return format;
	}
	
	
}
