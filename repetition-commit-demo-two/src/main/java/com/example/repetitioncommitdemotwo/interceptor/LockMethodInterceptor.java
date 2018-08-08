package com.example.repetitioncommitdemotwo.interceptor;

import com.example.repetitioncommitdemotwo.annotation.CacheLock;
import com.example.repetitioncommitdemotwo.util.RedisLockHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * redis方案
 * @author Jet
 */
@Aspect
@Configuration
public class LockMethodInterceptor {
    private final RedisLockHelper redisLockHelper;
    private final CacheKeyGenerator cacheKeyGenerator;
    @Autowired
    public LockMethodInterceptor(RedisLockHelper redisLockHelper, CacheKeyGenerator cacheKeyGenerator){
        this.redisLockHelper = redisLockHelper;
        this.cacheKeyGenerator = cacheKeyGenerator;
    }

    @Around("execution(public * *(..)) && @annotation(com.example.repetitioncommitdemotwo.annotation.CacheLock)")
    public Object interceptor(ProceedingJoinPoint pjp){
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Method method = signature.getMethod();
        CacheLock lock = method.getAnnotation(CacheLock.class);
        if(StringUtils.isEmpty(lock.prefix())){
            throw new RuntimeException("lock key don't null ...");
        }
        final String lockKey = cacheKeyGenerator.getLockKey(pjp);
        String value = UUID.randomUUID().toString();
        try{
            final boolean success = redisLockHelper.lock(lockKey,value,lock.expire(),lock.timeUnit());
            if(!success){
                throw new RuntimeException("重复提交");
            }
            try{
                return pjp.proceed();
            }catch (Throwable throwable){
                throw new RuntimeException("系统异常");
            }
        }finally {
            //TODO 如果演示的话需要注释该代码，实际应该放开
           // redisLockHelper.unlock(lockKey,value);
        }
    }
}
