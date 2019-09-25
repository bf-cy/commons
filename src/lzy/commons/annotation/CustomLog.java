package lzy.commons.annotation;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*****************************************************************************************************************************************************
 * desc 异常日志注解
 * 
 * @author lzy 2019年3月4日 下午1:49:01
 *****************************************************************************************************************************************************/
@Documented//生成文档
@Retention(RUNTIME)//注解在哪个阶段执行
@Target(METHOD)//注解放置的目标位置,METHOD是可注解在方法级别上
public @interface CustomLog {
	String value() default "";
}
