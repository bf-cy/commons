package lzy.commons.annotation;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD, TYPE_PARAMETER })
/*****************************************************************************************************************************************************
 * 使用方法，在mapper数据操作接口上添加DataSource注解，可以自己指定数据源切换判断字段，当前默认userId
 * 
 * @author lzy
 * @dateTime 2019年4月9日 下午2:52:34
 *****************************************************************************************************************************************************/
public @interface DataSource {
	
	/*****************************************************************************************************************************************************
	 * 动态数据源名称，标识使用哪个动态数据源，默认数据源是data
	 *切面方法中判断使用哪个动态数据源的依据
	 * @return 动态数据源名称
	 * @author lzy 2019年7月19日 下午6:00:23
	 *****************************************************************************************************************************************************/
	String dynamic() default "data";

	/*****************************************************************************************************************************************************
	 * 数据库分库条件字段名 
	 * 值为：default 代表使用默认数据源
	 * 值为：random 代表使用随机数据源
	 * 值为：all 代表使用所有数据源---该方式当前没有找到实现方式
	 * @return 动态数据源切换方式
	 * @author lzy 2019年7月19日 下午6:02:05
	 *****************************************************************************************************************************************************/
	String field() default "userId"; //字段
}
