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

}
