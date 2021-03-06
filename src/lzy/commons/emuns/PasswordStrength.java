/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年8月5日 下午1:23:00
 *****************************************************************************************************************************************************/
package lzy.commons.emuns;

import lzy.commons.utils.StringUtils;

/*****************************************************************************************************************************************************
 * Desc: 响应状态枚举
 * @author lzy 2019年8月5日 下午1:23:00
 *****************************************************************************************************************************************************/
public enum PasswordStrength {
	

	LETTER(1,"纯字母","弱"),
	NUMBER(2,"纯数字","弱"),
	CHARACTER(3,"纯字符","弱"),
	LETTER_NUMBER(4,"字母数字组合","中"),
	LETTER_CHARACTER(5,"字母数字组合","中"),
	CHARACTER_NUMBER(6,"字符数字组合","中"),
	LETTER_CHARACTER_NUMBER(1006,"字符数字字符组合","墙");

	/*****************************************************************************************************************************************************
	 * Desc: 值
	 * @author lzy @dateTime 2019年8月5日 下午1:40:48
	 *****************************************************************************************************************************************************/
	private int value;

	/*****************************************************************************************************************************************************
	 *  Desc: 名字
	 * @author lzy @dateTime 2019年8月5日 下午1:41:06
	 *****************************************************************************************************************************************************/
	private String name;
	/*****************************************************************************************************************************************************
	 *  Desc: 强度
	 * @author lzy @dateTime 2019年8月5日 下午1:41:06
	 *****************************************************************************************************************************************************/
	private String strength;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	
	/*****************************************************************************************************************************************************
	 * Desc: 枚举构造函数
	 * @param code 状态吗
	 * @param message 状态对应消息
	 * @author lzy 2019年8月5日 下午1:39:57
	 *****************************************************************************************************************************************************/
	private PasswordStrength(int value, String name,String strength) {
		this.value = value;
		this.name = name;
		this.strength = strength;
	}
	

	/*****************************************************************************************************************************************************
	 * Desc: 根据状态码（code）获取状态信息（code值最好是从状态信息中获取，否则可能查询为空）
	 * 
	 * @param value 状态码
	 * @return 状态信息存在返回状态信息，如果状态信息不存在返回空
	 * @author lzy 2019年8月5日 下午1:34:03
	 *****************************************************************************************************************************************************/
	public PasswordStrength getValue(int value) {
		for (PasswordStrength passwordStrength : values()) {
			if (passwordStrength.getValue()==value) {
				return passwordStrength;
			}
		}
		return null;
	}

	/*****************************************************************************************************************************************************
	 * Desc: 根据状态消息（msg）获取状态信息 （msg值最好是从状态信息中获取，否则可能查询为空）
	 * 
	 * @param name 消息内容
	 * @return 状态信息存在返回状态信息，如果状态信息不存在返回空
	 * @author lzy 2019年8月5日 下午1:34:03
	 *****************************************************************************************************************************************************/
	public PasswordStrength getMsg(String name) {
		if(StringUtils.isBlank(name)) {
			return null;
		}
		for (PasswordStrength passwordStrength : values()) {
			if (passwordStrength.getName().equals(name)) {
				return passwordStrength;
			}
		}
		return null;
	}
	
	/*****************************************************************************************************************************************************
	 * Desc: 根据状态消息（msg）获取状态信息 （msg值最好是从状态信息中获取，否则可能查询为空）
	 * 
	 * @param strength 消息内容
	 * @return 状态信息存在返回状态信息，如果状态信息不存在返回空
	 * @author lzy 2019年8月5日 下午1:34:03
	 *****************************************************************************************************************************************************/
	public PasswordStrength getStrength(String strength) {
		if(StringUtils.isBlank(strength)) {
			return null;
		}
		for (PasswordStrength passwordStrength : values()) {
			if (passwordStrength.getStrength().equals(strength)) {
				return passwordStrength;
			}
		}
		return null;
	}

}
