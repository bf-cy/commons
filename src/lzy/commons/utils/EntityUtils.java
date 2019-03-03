/**********************************************************************************
 * @Desc 
 * @author lzy
 * @date 2018年12月11日 下午6:44:10
 **********************************************************************************/
package lzy.commons.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**********************************************************************************
 * @Desc 实体类工具
 * @author lzy
 * @date 2018年12月11日 下午6:44:10
 **********************************************************************************/
public class EntityUtils {

	/**********************************************************************************
	 * @Desc 将源实体对象中和目标实体对象中一致的字段值放入目标对象中
	 * @param sourceEntity 源实体对象
	 * @param targetEntity 目标实体对象
	 * @return 实体对象转换之后返回map
	 * @author lzy
	 * @date 2018年11月5日 下午1:38:48
	 **********************************************************************************/
	public static void entityToEntity(Object sourceEntity,Object targetEntity) {
        if (sourceEntity == null || targetEntity == null) {
            return;
        }
        
	    Class<? extends Object> sourceClazz = sourceEntity.getClass();
        Field[] sourceFields = sourceClazz.getDeclaredFields();
	    Class<? extends Object> targetClazz = targetEntity.getClass();
	    Field[] targetFields = targetClazz.getDeclaredFields();
        try {
        	for(Field targetField : targetFields) {
        		for (Field sourceField : sourceFields) {
            		targetField.setAccessible(true);
                    sourceField.setAccessible(true);
                    //首先判断字段名是否相同，然后判断字段类型是否相同，最后判单源实体中字段是否不为空，如果三个条件都符合则将源实体中的字段值传入到目标实体中对应的字段中
                    if(targetField.getName().equals(sourceField.getName()) &&
                    	sourceField.getType().toString().equals(targetField.getType().toString())
                    	&& sourceField.get(sourceEntity)!=null) {
//                    	targetField.setAccessible(true);
                    	targetField.set(targetEntity, sourceField.get(sourceEntity));
                    	targetField.setAccessible(false);
                		break;
                	}
                }
            	targetField.setAccessible(false);
        	}
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	/**********************************************************************************
	 * @Desc 将实体对象转换为map
	 * @param entity 实体对象
	 * @return 实体对象转换之后返回map
	 * @author lzy
	 * @date 2018年11月5日 下午1:38:48
	 **********************************************************************************/
	public static HashMap<String, Object> entityToMap(Object entity) {
		HashMap<String, Object> map = new HashMap<String, Object>();
        if (entity == null) {
            return map;
        }
        Class<? extends Object> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
            	if(field.get(entity)==null) {
            		continue;
            	};
                map.put(field.getName(), field.get(entity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
	
	/**********************************************************************************
	 * @author lzy
	 * @date 2018年11月5日 下午1:38:48
	 * 将实体对象转换为map
	 * @param entity 实体对象
	 * @return PageData对象转换实体之后返回
	 **********************************************************************************/
	public static void MapToEntity(Map<String,Object> map,Object entity) {
        if (entity == null || map==null) {
            return;
        }
        Class<? extends Object> clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            if(map.get(fieldName)==null)
            	continue;
            Class<?> type = field.getType();
            Object value = map.get(fieldName);
            try {
				if(type == String.class){
					field.set(entity,value.toString());
				}else if(type == Integer.class || type == int.class){
					field.set(entity,Integer.parseInt(value.toString()));
				}else if(type == Long.class || type == long.class){
					field.set(entity,Long.parseLong(value.toString()));
				}else if(type == Byte.class || type == byte.class){
					field.set(entity,Byte.parseByte(value.toString()));
				}else if(type == Float.class || type == float.class){
					field.set(entity,Float.parseFloat(value.toString()));
				}else if(type == Double.class || type == double.class){
					field.set(entity,Double.parseDouble(value.toString()));
				}else if(type == Boolean.class || type == boolean.class){
					field.set(entity,Boolean.parseBoolean(value.toString()));
				}else if(type == Short.class || type == short.class){
					field.set(entity,Short.parseShort(value.toString()));
				}else if(type == Date.class){
					//日期
				}else if(type == BigDecimal.class){
					field.set(entity,new BigDecimal(value.toString()));
				}
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       
    }
	
	private static void setEntityField() {
	}
	
	
	/*****************************************************************************************************************************************************
	 * @desc 判断是否为空
	 * @param object 
	 * @return 
	 * @author lzy
	 * @dateTime 2019年3月3日 下午12:39:36
	 *****************************************************************************************************************************************************/
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		} else if (object instanceof String) {
			if (StringUtils.isEmpty((String) object)) {
				return true;
			}
		} else if (object instanceof List<?>) {
			List<?> list = (List<?>) object;
			if (list == null || list.size() <= 0) {
				return true;
			}
		} else if (object instanceof Object[]) {
			Object[] arr = (Object[]) object;
			if (arr == null || arr.length == 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNotEmpty(Object object) {
		return !isEmpty(object);
	}
}
