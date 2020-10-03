package com.legouu.common.AspectUtils;

import java.lang.annotation.*;

/**
 * 编写注解拦截器
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
