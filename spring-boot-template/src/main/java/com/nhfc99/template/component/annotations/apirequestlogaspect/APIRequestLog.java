package com.nhfc99.template.component.annotations.apirequestlogaspect;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface APIRequestLog {
    String contents() default "";
}