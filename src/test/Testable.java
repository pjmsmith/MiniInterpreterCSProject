package test;

import java.lang.annotation.*;

/**
 * Created Fri Jan 16 12:30:15 PST 2009 <br/>
 *
 * @author JUnit 4 Synchronizer
 * @version $Revision: $ <br/> $Date: $ <br/> $Author: $
 */
@Retention(value = RetentionPolicy.SOURCE)
@Target( { ElementType.CONSTRUCTOR, ElementType.METHOD } )
public @interface Testable {

    public abstract String value() default "";

} // Testable annotation type
