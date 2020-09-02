/**********************************************************************************
 * 
 * @author lzy
* 2018年12月13日 下午7:26:50
 **********************************************************************************/
package lzy.commons.utils;


import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;

import lzy.commons.emuns.PasswordStrength;
import lzy.commons.utils.time.DateTimeRegularUtils;

/**********************************************************************************
 * 
 * @author lzy
* 2018年12月13日 下午7:26:50
 **********************************************************************************/
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	//// @formatter:off

	// private final static String identity_card_regular =
	// "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
	// private final static String mobile_regular = "^1(3|4|5|6|7|8|9)\\d{9}$";
	private final static String mobile_regular_prefix = "^1(3|4|5|7|8)\\d{9}";// 手机号正则前缀
	private final static String mobile_regular = mobile_regular_prefix + "$";// 手机号正则
	private final static String tel_regular_prefix = "^((\\d{3,4})|\\d{3,4}-|\\s)?\\d{7,14}";// 固话号正则前缀
	private final static String tel_regular = tel_regular_prefix + "$";// 固话号正则
	private final static String mobile_tel_regular = "(" + mobile_regular_prefix + ")|(" + tel_regular_prefix + ")$";// 手机号或者固话号正则
	private final static String email_regular = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";// 邮箱正则
	// private final static String tel_regular =
	// "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
	private final static String website_regular = "^(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-Z0-9\\.&%\\$\\-]+)*@)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4})(\\:[0-9]+)?(/[^/][a-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$#\\=~_\\-@]*)*$";

	// @formatter:on
	/**********************************************************************************
	 * 将手机号中间4位替换为*号
	 * @param phone 手机号
	 * @return 中间四位替换为****之后的手机号
	 * @author lzy
* 2018年12月13日 下午7:27:54
	 **********************************************************************************/
	public static String phoneReplace(String phone) {
		if(phone!=null) {
			return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		}
		return null;
	}

	/*****************************************************************************************************************************************************
	 * 替换指定位置的字符串，如果字符串为空或者字符串小于指定字符串结束位置，则直接返回原字符串
	 * 
	 * @param str        原字符串
	 * @param start      字符开始位置
	 * @param end        字符结束位置
	 * @param replaceStr 指定位置需要替换成的字符串
	 * @return 返回替换后的字符串
	 *****************************************************************************************************************************************************/
	public static String replaceAssignStr(String str, int start, int end, String replaceStr) {
		if (str != null && str.length() > (end + 1)) {
			StringBuilder sb = new StringBuilder(str);
			sb.replace(start, end, "****");
			return sb.toString();
		} else {
			return str;
		}
	}

	/*****************************************************************************************************************************************************
	 * 将字符串转换为唯一编码
	 * 
	 * @param str 字符串
	 * @return 转换后的唯一编码
	 * @author lzy 2019年11月4日 下午2:56:32
	 *****************************************************************************************************************************************************/
	public static String uniqueCode(String str) {
		if (isBlank(str)) {
			return null;
		}
		return DigestUtils.md5Hex(str);
	}

	/*****************************************************************************************************************************************************
	 * 检查密码强度
	 * 
	 * @param passwordStr 密码字符串
	 * @return 密码强度
	 * @author lzy 2019年12月26日 下午12:46:35
	 *****************************************************************************************************************************************************/
	public static PasswordStrength checkPassword(String passwordStr) {
		// Z = 字母 S = 数字 T = 特殊字符
		String regexZ = "[A-Za-z]+";
		String regexS = "^\\d+$";
		String regexT = "[~!@#$%^&*.]+";
		String regexZT = "[a-zA-Z~!@#$%^&*.]+";
		String regexZS = "[0-9A-Za-z]+";
		String regexTS = "[\\d~!@#$%^&*.]*";
		String regexZTS = "[\\da-zA-Z~!@#$%^&*.]+";

		if (passwordStr.matches(regexZ)) {
			return PasswordStrength.LETTER;
		}
		if (passwordStr.matches(regexS)) {
			return PasswordStrength.NUMBER;
		}
		if (passwordStr.matches(regexT)) {
			return PasswordStrength.CHARACTER;
		}
		if (passwordStr.matches(regexZT)) {
			return PasswordStrength.LETTER_NUMBER;
		}
		if (passwordStr.matches(regexZS)) {
			return PasswordStrength.LETTER_CHARACTER;
		}
		if (passwordStr.matches(regexTS)) {
			return PasswordStrength.CHARACTER_NUMBER;
		}
		if (passwordStr.matches(regexZTS)) {
			return PasswordStrength.LETTER_CHARACTER_NUMBER;
		}
		return null;
	}

	// private final static String identity_card_regular =
	// "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";
	/*****************************************************************************************************************************************************
	 * 验证身份号是否有效
	 * 
	 * @param identityCard 身份证号
	 * @return 有效返回true,无效返回false
	 *****************************************************************************************************************************************************/
	public static boolean isIdentityCard(String identityCard) {
//				if (identityCard.matches(identity_card_regular)) {
//					return true;
//				} else {
//					return false;
//				}
		if (identityCard == null) {
			return false;
		}
		try {
			return IdentificationCardUtil.IDCardValidate(identityCard);
		} catch (Exception e) {
			return false;
		}
	}

	/*****************************************************************************************************************************************************
	 * 验证手机号是否有效
	 * 
	 * @param mobile 手机号
	 * @return 有效返回true,无效返回false
	 *****************************************************************************************************************************************************/
	public static boolean isMobile(String mobile) {
		if (mobile == null) {
			return false;
		}
		if (mobile.matches(mobile_regular)) {
			return true;
		} else {
			return false;
		}
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为固话号
	 * 
	 * @param tel 需要验证的固话号字符串
	 * @return 是日期返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isTel(String tel) {
		if (tel == null) {
			return false;
		}
		Pattern pattern = Pattern.compile(tel_regular);
		return pattern.matcher(tel).matches();
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为手机号或者固话号
	 * 
	 * @param MobileOrTel 需要验证的手机号或者固话号字符串
	 * @return 是日期返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isMobileOrTel(String MobileOrTel) {
		if (MobileOrTel == null) {
			return false;
		}
		Pattern pattern = Pattern.compile(mobile_tel_regular);
		return pattern.matcher(MobileOrTel).matches();
	}

	/*****************************************************************************************************************************************************
	 * 验证邮箱是否有效
	 * 
	 * @param email 邮箱
	 * @return 有效返回true,无效返回false
	 *****************************************************************************************************************************************************/
	public static boolean isEmail(String email) {
		if (email == null) {
			return false;
		}
		if (email.matches(email_regular)) {
			return true;
		} else {
			return false;
		}
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为整数
	 * 
	 * @param integer 需要验证的整数字符串
	 * @return 是整数返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isInteger(String integer) {
		if (integer == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(integer).matches();
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为数字(包含整数和小数)
	 * 
	 * @param numeric 需要验证的数字字符串
	 * @return 是整数返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isNumeric(String numeric) {
		if (numeric == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*?(.?[\\d]*)$");
		return pattern.matcher(numeric).matches();
	}


	/*****************************************************************************************************************************************************
	 * 验证是否为日期
	 * 
	 * @param date 需要验证的日期符串
	 * @return 是日期返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isDate(String date) {
		if (date == null) {
			return false;
		}
		Pattern pattern = Pattern.compile(DateTimeRegularUtils.date_regular);
		return pattern.matcher(date).matches();
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为日期时间
	 * 
	 * @param dateTime 需要验证的日期时间符串
	 * @return 是日期返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isDateTime(String dateTime) {
		if (dateTime == null) {
			return false;
		}
		Pattern pattern = Pattern.compile(DateTimeRegularUtils.date_time_regular);
		return pattern.matcher(dateTime).matches();
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为时间
	 * 
	 * @param time 需要验证的时间字符串
	 * @return 是日期返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isTime(String time) {
		if (time == null) {
			return false;
		}
		Pattern pattern = Pattern.compile(DateTimeRegularUtils.time_regular);
		return pattern.matcher(time).matches();
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为单行文本----匹配到换行符或者回车符
	 * 
	 * @param singleLineText 需要验证的单行文本字符串
	 * @return 匹配到换行符或者回车符返回false,否则返回true
	 *****************************************************************************************************************************************************/
	public static boolean isSingleLineText(String singleLineText) {
		if (singleLineText == null) {
			return true;
		}
		Pattern pattern = Pattern.compile("\\n|\\r");
		return !pattern.matcher(singleLineText).matches();
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为网址
	 * 
	 * @param website 需要验证的网址符串
	 * @return 是网址返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isWebsite(String website) {
		if (website == null) {
			return true;
		}
		Pattern pattern = Pattern.compile(website_regular);
		return !pattern.matcher(website).matches();
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为汉字
	 * 
	 * @param chineseCharacter 需要验证的汉字符串
	 * @return 是汉字字符串返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isChineseCharacter(String chineseCharacter) {
		if (chineseCharacter == null) {
			return true;
		}
		Pattern pattern = Pattern.compile("^[\\u4e00-\\u9fa5]+$");
		return !pattern.matcher(chineseCharacter).matches();
	}

	/*****************************************************************************************************************************************************
	 * 验证是否为英文字符串
	 * 
	 * @param english 需要验证的英文字符串
	 * @return 是英文字符串返回true,否则返回false
	 *****************************************************************************************************************************************************/
	public static boolean isEnglish(String english) {
		if (english == null) {
			return true;
		}
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		return !pattern.matcher(english).matches();
	}


	// =================================================================废弃方法----开始==============================================================================/
	// private final static String identity_card_regular =
	// "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";
	/*****************************************************************************************************************************************************
	 * 验证身份号是否有效--替代方法isIdentityCard
	 * 
	 * @param identityCard 身份证号
	 * @return 有效返回true,无效返回false
	 *****************************************************************************************************************************************************/
	@Deprecated
	public static boolean validIdentityCard(String identityCard) {
//			if (identityCard.matches(identity_card_regular)) {
//				return true;
//			} else {
//				return false;
//			}
		if (identityCard == null) {
			return false;
		}
		try {
			return IdentificationCardUtil.IDCardValidate(identityCard);
		} catch (Exception e) {
			return false;
		}
	}

	/*****************************************************************************************************************************************************
	 * 验证手机号是否有效--替代方法isMobile
	 * 
	 * @param mobile 手机号
	 * @return 有效返回true,无效返回false
	 *****************************************************************************************************************************************************/
	@Deprecated
	public static boolean validMobile(String mobile) {
		if (mobile == null) {
			return false;
		}
		if (mobile.matches(mobile_regular)) {
			return true;
		} else {
			return false;
		}
	}

	/*****************************************************************************************************************************************************
	 * 验证邮箱是否有效--替代方法isEmail
	 * 
	 * @param email 邮箱
	 * @return 有效返回true,无效返回false
	 *****************************************************************************************************************************************************/
	@Deprecated
	public static boolean validEmail(String email) {
		if (email == null) {
			return false;
		}
		if (email.matches(email_regular)) {
			return true;
		} else {
			return false;
		}
	}

	// =================================================================废弃方法----结束==============================================================================/

	public static void main(String[] args) {
//		System.out.println(date_regular_prefix);
//		boolean isMatchDate1 = isDate("2015-01-31");
//		boolean isMatchDate2 = isDate("2015-01-32");
//		boolean isMatchDate3 = isDate("2015-02-29");
//		boolean isMatchDate4 = isDate("2016-02-29");
//		boolean isMatchDate5 = isDate("2016-11-30");
//		System.out.println("字符串中是否是日期' 子字符串? " + isMatchDate1 + ";" + isMatchDate2 + ";" + isMatchDate3 + ";"
//				+ isMatchDate4 + ";" + isMatchDate5);
//
//		boolean isMatchTime1 = isTime("");
//		boolean isMatchTime2 = isTime("14:03:01");
//		boolean isMatchTime3 = isTime("14:60:01");
//		boolean isMatchTime4 = isTime("25:02:01");
//		boolean isMatchTime5 = isTime("14:13:73");
//		boolean isMatchTime6 = isTime("00:04:03");
//		boolean isMatchTime7 = isTime("24:00:01");
//		boolean isMatchTime8 = isTime("23:59:59");
//		System.out.println("字符串中是否是日期' 子字符串? " + isMatchTime1 + ";" + isMatchTime2 + ";" + isMatchTime3 + ";"
//				+ isMatchTime4 + ";" + isMatchTime5 + ";" + isMatchTime6 + ";" + isMatchTime7 + ";" + isMatchTime8);

	}

}
