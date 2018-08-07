package com.example.repetitioncommitdemoone.annotation;

import java.lang.annotation.*;

/**
 * 锁的注解
 * @author Jet
 */
@Target(ElementType.METHOD)   //注解修饰的对象范围
@Retention(RetentionPolicy.RUNTIME)  //定义了注解的保留时间长短
@Documented //用于描述其它类型的annotation应该被作为被标注的程序成员的公共API
@Inherited  //@Inherited阐述了某个被标注的类型是被继承的。
public @interface LocalLock {
    String key() default "";

    /**
     * 过期时间 TODO 由于用的 guava 暂时就忽略这属性吧 集成 redis 需要用到
     * @return
     */
    int expire() default 5;
}
