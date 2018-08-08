package com.example.repetitioncommitdemotwo.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Jet
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CacheLock {
    /**
     * redis 锁key的前缀
     * @return
     */
    String prefix() default "";

    /**
     * 过期秒数，默认为5s
     * @return 轮询锁时间
     */
    int expire() default 5;

    /**
     * 超时时间单位
     * @return
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;

    /**
     * Key的分隔符(默认:)
     * 生成的key：N：SO1008:500
     * @return
     */
    String delimiter() default ":";
}
