/*****************************************************************************************************************************************************
 * 
 * 
 * @author lzy
* 2019年6月19日 下午2:07:17
 *****************************************************************************************************************************************************/
package lzy.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lzy.commons.exception.UtilException;

/*****************************************************************************************************************************************************
 * 身份证工具类
 * 在上世纪（二十世纪）办的身份证为15位数字码。原来7、8位的年份号到2000年后攺为全称，如1985年过去7、8位码是85，现在增改为1985，而又在最后一位增加校验码，如后三位原来601，加一个5成为6015。身份证一经编定不作改变，派出所会在户口资料中给你加上，你要换新证时就是18位的新码了。
 * 公民身份证号码按照 GB11643—1999《公民身份证号码》国家标准编制，由18位数字组成：前6位为行政区划分代码，第7位至14位为出生日期码，第15位至17位为顺序码，第18位为校验码。
 * 
 * @author lzy  2019年6月19日 下午2:07:17
 *****************************************************************************************************************************************************/
public class IdentificationCardUtil {

    /*****************************************************************************************************************************************************
     * 18位身份证 根据身份证的号码算出当前身份证持有者的性别和年龄
     * @param CardCode 身份证号
     * @return map 包含性别和年龄 性别：sex，年龄：age，birthday：生日
     * @throws Exception 异常
     * @author lzy 2019年6月19日 下午2:07:56
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
     * 18位身份证 根据身份证的号码算出当前身份证持有者的性别
     * @param CardCode 18位身份证号
     * @return String  性别：男/女
     * @author lzy 2019年6月19日 下午2:07:56
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
     * 18位身份证 根据身份证的号码算出当前身份证持有者的性别年龄
     * @param CardCode 身份证号
     * @return int 年龄
     * @author lzy 2019年6月19日 下午2:07:56
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
     * 18位身份证获取生日
     * @param CardCode 身份证号
     * @return date 生日
     * @author lzy 2019年6月19日 下午2:31:47
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
     * 15位身份证的验证 根据身份证的号码算出当前身份证持有者的性别和年龄
     * @param CardCode 身份证号
     * @return map 包含性别和年龄 性别：sex，年龄：age，birthday：生日
     * @throws Exception 异常
     * @author lzy 2019年6月19日 下午2:09:18
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
     * 15位身份证的验证 根据15身份证的号码算出当前身份证持有者的性别
     * @param CardCode 15位身份证号
     * @return string 性别：男/女
     * @author lzy 2019年6月19日 下午2:34:49
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
     * 15位身份证的验证 根据身份证的号码算出当前身份证持有者的年龄
     * @param CardCode 15位身份证号
     * @return int 年龄
     * @author lzy 2019年6月19日 下午2:34:52
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
     * 15位身份证 根据身份证的号码算出当前身份证持有者的生日
     * @param CardCode 身份证号
     * @return date 生日
     * @author lzy 2019年6月19日 下午2:31:47
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
    
    
    
    /*****************************************************************************************************************************************************
     * 验证身份证号是否正确
     * @param IDStr 身份证号
     * @return 返回校验结果
     * @author lzy 2019年7月30日 下午12:32:25
     *****************************************************************************************************************************************************/
    @SuppressWarnings({ "unused", "rawtypes" })
	public static boolean IDCardValidate(String IDStr) {
        try {
			String tipInfo = "该身份证有效！";// 记录错误信息 
			Map<String, Object> map = new HashMap<String, Object>();
			String Ai = "";  
			// 判断号码的长度 15位或18位  
			if (IDStr.length() != 15 && IDStr.length() != 18) {  
				tipInfo = "身份证号码长度应该为15位或18位。";
			    throw new UtilException(tipInfo);
			}  
			  
  
			// 18位身份证前17位位数字，如果是15位的身份证则所有号码都为数字  
			if (IDStr.length() == 18) {  
			    Ai = IDStr.substring(0, 17);  
			} else if (IDStr.length() == 15) {  
			    Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);  
			}  
			if (isNumeric(Ai) == false) {  
				tipInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。";
			    throw new UtilException(tipInfo);  
			}  
			  
  
			// 判断出生年月是否有效   
			String strYear = Ai.substring(6, 10);// 年份  
			String strMonth = Ai.substring(10, 12);// 月份  
			String strDay = Ai.substring(12, 14);// 日期  
			if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {  
			    tipInfo = "身份证出生日期无效。";  
			    throw new UtilException(tipInfo);
			}  
			GregorianCalendar gc = new GregorianCalendar();  
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");  
			try {  
			    if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150  
			            || (gc.getTime().getTime() - s.parse(  
			                    strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {  
			        tipInfo = "身份证生日不在有效范围。"; 
			        throw new UtilException(tipInfo);
			    }  
			} catch (NumberFormatException e) {  
			    e.printStackTrace();  
			} catch (java.text.ParseException e) {  
			    e.printStackTrace();  
			}  
			if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {  
			    tipInfo = "身份证月份无效";  
			    throw new UtilException(tipInfo);
			}  
			if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {  
			    tipInfo = "身份证日期无效";  
			    throw new UtilException(tipInfo);
			}  
			  
  
			// 判断地区码是否有效   
			Hashtable areacode = GetAreaCode();  
			//如果身份证前两位的地区码不在Hashtable，则地区码有误  
			if (areacode.get(Ai.substring(0, 2)) == null) {  
			    tipInfo = "身份证地区编码错误。"; 
			    throw new UtilException(tipInfo);
			}  
			  
			if(isVarifyCode(Ai,IDStr)==false){  
			    tipInfo = "身份证校验码无效，不是合法的身份证号码";  
			    throw new UtilException(tipInfo);
			}
		} catch (NumberFormatException e) {
			throw new UtilException(e.getMessage());
		}  
         
        return true;
    }  
      
      
    /*****************************************************************************************************************************************************
     * 判断第18位校验码是否正确 
     	第18位校验码的计算方式：  
	        　　1. 对前17位数字本体码加权求和  
	        　　公式为：S = Sum(Ai * Wi), i = 0, ... , 16  
	        　　其中Ai表示第i个位置上的身份证号码数字值，Wi表示第i位置上的加权因子，其各位对应的值依次为： 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2  
	        　　2. 用11对计算结果取模  
	        　　Y = mod(S, 11)  
	        　　3. 根据模的值得到对应的校验码  
	        　　对应关系为：  
	        　　 Y值：     0  1  2  3  4  5  6  7  8  9  10  
	        　　校验码： 1  0  X  9  8  7  6  5  4  3   2 
     * @param Ai 身份证主体（除了身份证最后一位校验位意外的字符串）
     * @param IDStr 身份证号字符串
     * @return 返回身份证号校验位是否正确 true:正确；false:不正确
     * @author lzy 2019年7月30日 下午12:29:07
     *****************************************************************************************************************************************************/
    private static boolean isVarifyCode(String Ai,String IDStr) {  
         String[] VarifyCode = { "1", "0", "X", "9", "8", "7", "6", "5", "4","3", "2" };  
         String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7","9", "10", "5", "8", "4", "2" };  
         int sum = 0;  
         for (int i = 0; i < 17; i++) {  
            sum = sum + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);  
         }  
         int modValue = sum % 11;  
         String strVerifyCode = VarifyCode[modValue];  
         Ai = Ai + strVerifyCode;  
         if (IDStr.length() == 18) {  
             if (Ai.equals(IDStr) == false) {  
                 return false;  
                  
             }  
         }   
         return true;  
    }  
      
  
    /*****************************************************************************************************************************************************
     * 将所有地址编码保存在一个Hashtable中    
     * @return 返回所有地址编码的 Hashtable
     * @author lzy 2019年7月30日 下午12:28:35
     *****************************************************************************************************************************************************/
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static Hashtable GetAreaCode() {  
        Hashtable hashtable = new Hashtable();  
        hashtable.put("11", "北京");  
        hashtable.put("12", "天津");  
        hashtable.put("13", "河北");  
        hashtable.put("14", "山西");  
        hashtable.put("15", "内蒙古");  
        hashtable.put("21", "辽宁");  
        hashtable.put("22", "吉林");  
        hashtable.put("23", "黑龙江");  
        hashtable.put("31", "上海");  
        hashtable.put("32", "江苏");  
        hashtable.put("33", "浙江");  
        hashtable.put("34", "安徽");  
        hashtable.put("35", "福建");  
        hashtable.put("36", "江西");  
        hashtable.put("37", "山东");  
        hashtable.put("41", "河南");  
        hashtable.put("42", "湖北");  
        hashtable.put("43", "湖南");  
        hashtable.put("44", "广东");  
        hashtable.put("45", "广西");  
        hashtable.put("46", "海南");  
        hashtable.put("50", "重庆");  
        hashtable.put("51", "四川");  
        hashtable.put("52", "贵州");  
        hashtable.put("53", "云南");  
        hashtable.put("54", "西藏");  
        hashtable.put("61", "陕西");  
        hashtable.put("62", "甘肃");  
        hashtable.put("63", "青海");  
        hashtable.put("64", "宁夏");  
        hashtable.put("65", "新疆");  
        hashtable.put("71", "台湾");  
        hashtable.put("81", "香港");  
        hashtable.put("82", "澳门");  
        hashtable.put("91", "国外");  
        return hashtable;  
    }  
    /*****************************************************************************************************************************************************
     * 判断字符串是否为数字,0-9重复0次或者多次   
     * @param strnum 字符串数字
     * @return 返回判断结果 true:字符串全是数字，false：字符串不全是数字
     * @author lzy 2019年7月30日 下午12:26:36
     *****************************************************************************************************************************************************/
    private static boolean isNumeric(String strnum) {  
        Pattern pattern = Pattern.compile("[0-9]*");  
        Matcher isNum = pattern.matcher(strnum);  
        if (isNum.matches()) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
    /*****************************************************************************************************************************************************
     * 功能：判断字符串出生日期是否符合正则表达式：包括年月日，闰年、平年和每月31天、30天和闰月的28天或者29天
     * @param strDate 日期字符串
     * @return 返回判断结果 true:是日期字符串，false：不是日期字符串
     * @author lzy 2019年7月30日 下午12:25:31
     *****************************************************************************************************************************************************/
    public static boolean isDate(String strDate) {
      
        Pattern pattern = Pattern  
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");  
        Matcher m = pattern.matcher(strDate);  
        if (m.matches()) {  
            return true;  
        } else {  
            return false;  
        }  
    }
      
//    public static void main(String[] args) throws ParseException {  
//        
//        //String IdCard="61082120061222612X";  
//        //从控制端输入用户身份证  
//        Scanner s=new Scanner(System.in);  
//        System.out.println("请输入你的身份证号码：");  
//        String IdCard=new String(s.next());  
//        //将身份证最后一位的x转换为大写，便于统一  
//        IdCard = IdCard.toUpperCase();  
//        System.out.println(IDCardValidate(IdCard));  
//    }  
//      
  
}
