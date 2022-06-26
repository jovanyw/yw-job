package com.jovan.job.common.annotation;

import java.lang.annotation.*;

/**
 * @author yw
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface JobHandler {
    String value();

    String init() default "";

    String destroy() default "";
}
