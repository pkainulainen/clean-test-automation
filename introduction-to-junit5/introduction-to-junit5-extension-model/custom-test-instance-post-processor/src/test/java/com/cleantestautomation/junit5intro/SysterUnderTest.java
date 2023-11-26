package com.cleantestautomation.junit5intro;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A marker annotation which is used for two purposes:
 * <ul>
 *     <li>
 *         It identifies the field which must contain a {@link MessageService}
 *         object. The {@link MessageServiceExtension} class will use this
 *         information when it injects the required dependency to a test class
 *         which registers the {@link MessageServiceExtension}.
 *     </li>
 *     <li>
 *         It allows you to configure the message that passed to the created
 *         {@link MessageService} object. If you don't configure tis message,
 *         the {@link MessageServiceExtension} will use the default message
 *         which is: 'Hello World!'.
 *     </li>
 * </ul>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface SysterUnderTest {

    String message() default "Hello world!";
}
