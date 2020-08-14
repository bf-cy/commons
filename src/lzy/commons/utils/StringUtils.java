/**********************************************************************************
 * 
 * @author lzy
* 2018年12月13日 下午7:26:50
 **********************************************************************************/
package lzy.commons.utils;


import org.apache.commons.codec.digest.DigestUtils;

import lzy.commons.emuns.PasswordStrength;

/**********************************************************************************
 * 
 * @author lzy
* 2018年12月13日 下午7:26:50
 **********************************************************************************/
public class StringUtils extends org.apache.commons.lang3.StringUtils {

	// private final static String identity_card_regular =
	// "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
	// private final static String mobile_regular = "^1(3|4|5|6|7|8|9)\\d{9}$";
	private final static String mobile_regular = "^1(3|4|5|7|8)\\d{9}$";
	private final static String email_regular = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	// private final static String tel_regular =
	// "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";

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
	 * 将字符串转换为唯一编码
	 * @param str 字符串
	 * @return 转换后的唯一编码
	 * @author lzy 2019年11月4日 下午2:56:32
	 *****************************************************************************************************************************************************/
	public static String uniqueCode(String str) {
		if(isBlank(str)) {
			return null;
		}
		return DigestUtils.md5Hex(str);
	}
	
	/*****************************************************************************************************************************************************
	 * 检查密码强度
	 * @param passwordStr 密码字符串
	 * @return 密码强度
	 * @author lzy 2019年12月26日 下午12:46:35
	 *****************************************************************************************************************************************************/
	public static PasswordStrength checkPassword(String passwordStr) {
	    // Z = 字母       S = 数字           T = 特殊字符
	    String regexZ = "[A-Za-z]+";
	    String regexS = "^\\d+$";
	    String regexT = "[~!@#$%^&*.]+";
	    String regexZT = "[a-zA-Z~!@#$%^&*.]+";
	    String regexZS = "[0-9A-Za-z]+";
	    String regexTS = "[\\d~!@#$%^&*.]*";
	    String regexZTS = "[\\da-zA-Z~!@#$%^&*.]+";
	 
	    if (passwordStr.matches(regexZ)){
	        return PasswordStrength.LETTER;
	    }
	    if (passwordStr.matches(regexS)){
	    	return PasswordStrength.NUMBER;
	    }
	    if (passwordStr.matches(regexT)){
	    	return PasswordStrength.CHARACTER;
	    }
	    if (passwordStr.matches(regexZT)){
	    	return PasswordStrength.LETTER_NUMBER;
	    }
	    if (passwordStr.matches(regexZS)){
	    	return PasswordStrength.LETTER_CHARACTER;
	    }
	    if (passwordStr.matches(regexTS)){
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
	public static boolean validIdentityCard(String identityCard) {
//		if (identityCard.matches(identity_card_regular)) {
//			return true;
//		} else {
//			return false;
//		}
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
	public static boolean validMobile(String mobile) {
		if (mobile.matches(mobile_regular)) {
			return true;
		} else {
			return false;
		}
	}

	/*****************************************************************************************************************************************************
	 * 验证邮箱是否有效
	 * 
	 * @param mobile 邮箱
	 * @return 有效返回true,无效返回false
	 *****************************************************************************************************************************************************/
	public static boolean validEmail(String email) {
		if (email.matches(email_regular)) {
			return true;
		} else {
			return false;
		}
	}

	/*****************************************************************************************************************************************************
	 * 替换指定位置的字符串，如果字符串为空或者字符串小于指定字符串结束位置，则直接返回原字符串
	 * 
	 * @param str        原字符串
	 * @param start      字符开始位置
	 * @param end        字符结束位置
	 * @param replaceStr 指定位置需要替换成的字符串
	 * @return
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

}
