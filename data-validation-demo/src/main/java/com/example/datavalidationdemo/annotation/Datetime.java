package com.example.datavalidationdemo.annotation;

import com.example.datavalidationdemo.validator.DateTimeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD,PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = DateTimeValidator.class)
public @interface Datetime {
    /**
     * 错误消息
     * @return 默认错误消息
     */
    String message() default "格式错误";

    /**
     * 验证日期格式
     * @return
     */
    String format() default "yyyy-MM-dd";

    /**
     * 允许我们为约束指定验证组 - 关键字段
     * @return
     */
    Class<?>[] groups() default {};

    /**
     * 约束注解的有效负载
     * @return
     */
    Class<? extends Payload>[] payload() default {};
}
