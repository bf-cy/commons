/*****************************************************************************************************************************************************
 * @desc 
 * 
 * @author lzy
 * @date 2019年6月19日 下午2:07:17
 *****************************************************************************************************************************************************/
package lzy.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lzy.commons.exception.UtilException;

/*****************************************************************************************************************************************************
 * @desc 身份证工具类
 * 
 * @author lzy
 * @dateTime 2019年6月19日 下午2:07:17
 *****************************************************************************************************************************************************/
public class IdentificationCardUtil {

    /*****************************************************************************************************************************************************
     * @desc 18位身份证 根据身份证的号码算出当前身份证持有者的性别和年龄
     * @param CardCode 身份证号
     * @return map 包含性别和年龄 性别：sex，年龄：age，birthday：生日
     * @throws Exception
     * @author lzy
     * @dateTime 2019年6月19日 下午2:07:56
     *****************************************************************************************************************************************************/
    public static Map<String, Object> getCarInfo(String CardCode)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String sex=getSex(CardCode);
        int age = getAge(CardCode);
        Date birthday = getBirthday(CardCode);
        map.put("sex", sex);
        map.put("age", age);
        map.put("birthday", birthday);
        return map;
    }
    
    
    /*****************************************************************************************************************************************************
     * @desc 18位身份证 根据身份证的号码算出当前身份证持有者的性别
     * @param CardCode 18位身份证号
     * @return String  性别：男/女
     * @throws Exception
     * @author lzy
     * @dateTime 2019年6月19日 下午2:07:56
     *****************************************************************************************************************************************************/
    public static String getSex(String CardCode){
        try {
			String sex;
			if (Integer.parseInt(CardCode.substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
			    sex = "女";
			} else {
			    sex = "男";
			}
			return sex;
		} catch (Exception e) {
			throw new UtilException("根据18身份证的号码算出当前身份证持有者的性别错误；原身份证号："+CardCode);
		}
    }
    

    /*****************************************************************************************************************************************************
     * @desc 18位身份证 根据身份证的号码算出当前身份证持有者的性别年龄
     * @param CardCode 身份证号
     * @return int 年龄
     * @throws Exception
     * @author lzy
     * @dateTime 2019年6月19日 下午2:07:56
     *****************************************************************************************************************************************************/
    public static int getAge(String CardCode){
    	try {
			String year = CardCode.substring(6).substring(0, 4);// 得到年份
			String yue = CardCode.substring(10).substring(0, 2);// 得到月份
	        // String day=CardCode.substring(12).substring(0,2);//得到日
			Date date = new Date();// 得到当前的系统时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String fyear = format.format(date).substring(0, 4);// 当前年份
			String fyue = format.format(date).substring(5, 7);// 月份
			// String fday=format.format(date).substring(8,10);
			int age = 0;
			if (Integer.parseInt(yue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生
			    age = Integer.parseInt(fyear) - Integer.parseInt(year) + 1;
			} else {// 当前用户还没过生
			    age = Integer.parseInt(fyear) - Integer.parseInt(year);
			}
      return age;
		} catch (Exception e) {
			throw new UtilException("根据18身份证的号码算出当前身份证持有者的年龄错误；原身份证号："+CardCode);
		}
    }
    

    /*****************************************************************************************************************************************************
     * @desc 18位身份证获取生日
     * @param CardCode 身份证号
     * @return date 生日
     * @author lzy
     * @dateTime 2019年6月19日 下午2:31:47
     *****************************************************************************************************************************************************/
    public static Date getBirthday(String CardCode){
        try {
        	String birthdayStr = CardCode.substring(6).substring(0, 8);// 得到年份
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date birthday = format.parse(birthdayStr);
			return birthday;
		} catch (Exception e) {
			throw new UtilException("根据18身份证的号码算出当前身份证持有者的生日错误；原身份证号："+CardCode);
		}
    }
 
    /*****************************************************************************************************************************************************
     * @desc 15位身份证的验证 根据身份证的号码算出当前身份证持有者的性别和年龄
     * @param CardCode 身份证号
     * @return map 包含性别和年龄 性别：sex，年龄：age，birthday：生日
     * @throws Exception
     * @author lzy
     * @dateTime 2019年6月19日 下午2:09:18
     *****************************************************************************************************************************************************/
    public static Map<String, Object> getCarInfo15(String CardCode)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String sex = get15Sex(CardCode);
        int age = get15Age(CardCode);
        Date birthday = get15Birthday(CardCode);
        map.put("sex", sex);
        map.put("age", age);
        map.put("birthday", birthday);
        return map;
    }

    /*****************************************************************************************************************************************************
     * @desc 15位身份证的验证 根据15身份证的号码算出当前身份证持有者的性别
     * @param CardCode 15位身份证号
     * @return string 性别：男/女
     * @author lzy
     * @dateTime 2019年6月19日 下午2:34:49
     *****************************************************************************************************************************************************/
    public static String get15Sex(String CardCode){
        try {
			String usex = CardCode.substring(14, 15);// 用户的性别
			String sex;
			if (Integer.parseInt(usex) % 2 == 0) {
			    sex = "女";
			} else {
			    sex = "男";
			}
			return sex;
		} catch (Exception e) {
			throw new UtilException("根据15身份证的号码算出当前身份证持有者的性别错误；原身份证号："+CardCode);
		}
    }

    /*****************************************************************************************************************************************************
     * @desc 15位身份证的验证 根据身份证的号码算出当前身份证持有者的年龄
     * @param CardCode 15位身份证号
     * @return int 年龄
     * @author lzy
     * @dateTime 2019年6月19日 下午2:34:52
     *****************************************************************************************************************************************************/
    public static int get15Age(String CardCode){
        try {
			String uyear = "19" + CardCode.substring(6, 8);// 年份
			String uyue = CardCode.substring(8, 10);// 月份
			// String uday=card.substring(10, 12);//日
			Date date = new Date();// 得到当前的系统时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String fyear = format.format(date).substring(0, 4);// 当前年份
			String fyue = format.format(date).substring(5, 7);// 月份
			// String fday=format.format(date).substring(8,10);
			int age = 0;
			if (Integer.parseInt(uyue) <= Integer.parseInt(fyue)) { // 当前月份大于用户出身的月份表示已过生
			    age = Integer.parseInt(fyear) - Integer.parseInt(uyear) + 1;
			} else {// 当前用户还没过生
			    age = Integer.parseInt(fyear) - Integer.parseInt(uyear);
			}
			return age;
		} catch (Exception e) {
			throw new UtilException("根据15身份证的号码算出当前身份证持有者的年龄错误；原身份证号："+CardCode);
		}
    }
    /*****************************************************************************************************************************************************
     * @desc 15位身份证 根据身份证的号码算出当前身份证持有者的生日
     * @param CardCode 身份证号
     * @return date 生日
     * @author lzy
     * @dateTime 2019年6月19日 下午2:31:47
     *****************************************************************************************************************************************************/
    public static Date get15Birthday(String CardCode){
        try {
			String birthdayStr = "19" + CardCode.substring(6, 12);// 出生日期
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			Date birthday = format.parse(birthdayStr);
			return birthday;
		} catch (Exception e) {
			throw new UtilException("根据15身份证的号码算出当前身份证持有者的生日错误；原身份证号："+CardCode);
		}
    }
}