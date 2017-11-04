/**
 * 
 */
package sid.spring.dateformatter.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author sidnan
 *
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyDateTimeZoneFormat {

	String timezone() default "UTC";
	
	String pattern() default "yyyy-MM-dd HH:mm:ss";
}

