/*****************************************************************************************************************************************************
 * 
 * 
 * @author lzy
* 2019年3月3日 下午1:55:28
 *****************************************************************************************************************************************************/
package lzy.commons.utils;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/*****************************************************************************************************************************************************
 * 自定义对象判断工具类
 * 
 * @author lzy 2019年3月3日 下午1:55:28
 *****************************************************************************************************************************************************/
public class CustomObjectUtils extends ObjectUtils{

	public static boolean isNotEmpty(Object obj) {
		if(obj==null){
			return false;
		}
		if(obj instanceof Object[]){
			Object[] objArray = (Object[])obj;
			if(objArray.length==0) {
				return true;
			}else {
				return false;
			}
		}else if(obj instanceof Collection){
			Collection<?> collection = (Collection<?>)obj;
			return !collection.isEmpty();
		}else if(obj instanceof Map){
			Map<?, ?> map = (Map<?, ?>)obj;
			return !map.isEmpty();
		}else {
			return StringUtils.isNotEmpty(obj.toString());
		}
	}
	
	
	public static boolean isEmpty(Object obj) {
		if(obj==null){
			return false;
		}
		if(obj instanceof Object[]){
			Object[] objArray = (Object[])obj;
			if(objArray.length==0) {
				return true;
			}else {
				return false;
			}
		}else if(obj instanceof Collection){
			Collection<?> collection = (Collection<?>)obj;
			return collection.isEmpty();
		}else if(obj instanceof Map){
			Map<?, ?> map = (Map<?, ?>)obj;
			return map.isEmpty();
		}else {
			return StringUtils.isEmpty(obj.toString());
		}
	}

}
