package device.itself.annotaion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value= {ElementType.FIELD,ElementType.LOCAL_VARIABLE})
public @interface ContextField {
	String Key() default "";
	String Value() default "";
}
