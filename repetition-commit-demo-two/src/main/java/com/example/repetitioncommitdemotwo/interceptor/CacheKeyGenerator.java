package com.example.repetitioncommitdemotwo.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * key生成器
 * @author jet
 */
public interface CacheKeyGenerator {
    /**
     * 获取AOP参数，生成指定缓存key
     * @param pjp
     * @return 缓存key
     */
    String getLockKey(ProceedingJoinPoint pjp);
}
