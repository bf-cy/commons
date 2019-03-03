package lzy.commons.utils;


import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;



/*****************************************************************************************************************************************************
 * @desc 
 * 
 * @author lzy
 * @dateTime 2019年3月3日 下午1:42:23
 *****************************************************************************************************************************************************/
public class EntityData extends HashMap<String, Object> implements Map<String, Object> {

	private static final long serialVersionUID = -1302811066779944372L;
	Map<String, Object> map = null;
	HttpServletRequest request;

	public EntityData(HttpServletRequest request) {
		this.request = request;
		Map<String, String[]> properties = request.getParameterMap();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Iterator<Entry<String, String[]>> entries = properties.entrySet().iterator();
		Map.Entry<String, String[]> entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry<String, String[]>) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
//				if (values.length > 1) {
//					returnMap.put(name + "_values", values);
//				}

				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
//			returnMap.put(name, SqlInjectInterceptor.stripXSSAndSql(value));
//			returnMap.put(name, HtmlUtils.htmlEscape(value));
			returnMap.put(name, value);
		}
		map = returnMap;
	}

	public EntityData() {
		map = new HashMap<String, Object>();
	}

	@Override
	public Object get(Object key) {
		Object obj = null;
		if (map.get(key) instanceof Object[]) {
			Object[] arr = (Object[]) map.get(key);
			obj = request == null ? arr : (request.getParameter((String) key) == null ? arr : arr[0]);
		} else {
			obj = map.get(key);
		}
		return obj;
	}

	public String getString(Object key) {
		Object obj = get(key);
		if (CustomObjectUtils.isNotEmpty(obj)) {
			return obj.toString();
		}
		return null;
	}

	public Integer getInteger(Object key) {
		Object obj = get(key);
		if (CustomObjectUtils.isNotEmpty(obj)) {
			return Integer.valueOf(obj.toString());
		}
		return null;
	}

	
	

	@Override
	public Object put(String key, Object value) {
		return map.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public Set entrySet() {
		return map.entrySet();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Set keySet() {
		return map.keySet();
	}

	public void putAll(Map t) {
		map.putAll(t);
	}

	public int size() {
		return map.size();
	}

	public Collection values() {
		return map.values();
	}

	/********************************************************************************************************************************************************************
	 * @author lzy 开始
	 ********************************************************************************************************************************************************************/ 
	/**********************************************************************************
	 * @Desc 将指定键对应值转换为Byte
	 * @param key
	 * @return
	 **********************************************************************************/
	public Byte getByte(Object key) {
		Object obj = get(key);
		if (CustomObjectUtils.isNotEmpty(obj)) {
			try {
				return Byte.parseByte(obj.toString());
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}
	/**********************************************************************************
	 * @Desc 将指定键对应值转换为Float
	 * @param key
	 * @return
	 **********************************************************************************/
	public Float getFloat(Object key) {
		Object obj = get(key);
		if (CustomObjectUtils.isNotEmpty(obj)) {
			try {
				return Float.parseFloat(obj.toString());
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return null;
	}
	/**********************************************************************************
	 * @Desc 将指定键对应值转换为Double
	 * @param key
	 * @return
	 **********************************************************************************/
	public Double getDouble(Object key) {
		Object obj = get(key);
		if (CustomObjectUtils.isNotEmpty(obj)) {
			try {
				return Double.parseDouble(obj.toString());
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return null;
	}
	/*****************************************************************************************************************************************************
	 * @Desc 将指定键对应值转换为Long
	 * @param key
	 * @return
	 * @author lzy
	 * @dateTime 2019年3月3日 上午9:50:28
	 *****************************************************************************************************************************************************/
	public Long getLong(Object key) {
		Object obj = get(key);
		if (CustomObjectUtils.isNotEmpty(obj)) {
			try {
				return Long.parseLong(obj.toString());
			} catch (NumberFormatException e) {
				return null;
			}
		}
		return null;
	}

	/*****************************************************************************************************************************************************
	 * @Desc 将指定键对应值转换为Byte
	 * @param key
	 * @return
	 * @author lzy
	 * @dateTime 2019年3月3日 上午9:50:44
	 *****************************************************************************************************************************************************/
	public Date getDate(Object key) {
		Object obj = get(key);
		if (obj instanceof Date) {
			return (Date)obj;
		}
		return null;
	}


}
