/*****************************************************************************************************************************************************
 * 
 * @author lzy 2019年10月6日 下午12:27:41
 *****************************************************************************************************************************************************/
package lzy.commons.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.Import;

import lzy.commons.mybatis.CustomMapperScannerRegistrar;


/*****************************************************************************************************************************************************
 * 当前注解直接复制与MapperScan，仅修改了 引入类 ：CustomMapperScannerRegistrar
 * @author lzy 2019年10月6日 下午12:27:41
 *****************************************************************************************************************************************************/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(CustomMapperScannerRegistrar.class)
public @interface CustomMapperScan {
	
	  String[] value() default {};

	  String[] basePackages() default {};

	Class<?>[] basePackageClasses() default {};

	  Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;

	  Class<? extends Annotation> annotationClass() default Annotation.class;

	  Class<?> markerInterface() default Class.class;

	  String sqlSessionTemplateRef() default "";

	  String sqlSessionFactoryRef() default "";

	  Class<? extends MapperFactoryBean> factoryBean() default MapperFactoryBean.class;

}
