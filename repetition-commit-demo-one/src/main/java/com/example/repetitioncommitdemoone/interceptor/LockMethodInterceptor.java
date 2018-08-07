package com.example.repetitioncommitdemoone.interceptor;

/**
 * 这个demo基于本地缓存
 */

import com.example.repetitioncommitdemoone.annotation.LocalLock;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class LockMethodInterceptor {
    private static final Cache<Object, Object> CACHES = CacheBuilder.newBuilder()//构建缓存对象
            //最大缓存100个
            .maximumSize(1000)
            //设置写缓存后5s钟过期
            .expireAfterAccess(5, TimeUnit.SECONDS)
            .build();
    @Around("execution(public * *(..)) && @annotation(com.example.repetitioncommitdemoone.annotation.LocalLock)")
    //第一个*表示返回类型，第二个*表示类名
    public Object interceptor(ProceedingJoinPoint pjp){
        MethodSignature signature = (MethodSignature)pjp.getSignature();
        Method method = signature.getMethod();
        LocalLock localLock = method.getAnnotation(LocalLock.class);
        String key = getKey(localLock.key(),pjp.getArgs());//pjp.getArgs()是得到方法参数
        if(!StringUtils.isEmpty(key)){
            if(CACHES.getIfPresent(key) != null){
                throw new RuntimeException("请勿重复请求");
            }
            CACHES.put(key,key);
        }
        try{
            return pjp.proceed();//返回方法函数运行结果
        }catch (Throwable throwable){
            throw new RuntimeException("服务器异常");
        }finally {
            //TODO 为了演示效果，这里不调用CACHES.invalidate(key)
        }
    }

    /**
     * key的生成策略，如果想灵活可以写成接口与实现类的方式
     * @param keyExpress 表达式
     * @param args  参数
     * @return  生成的key
     */
    public String getKey(String keyExpress,Object[] args){
        System.out.println("key: " + keyExpress);
        for(int i = 0;i < args.length; i++){
            keyExpress = keyExpress.replace("arg[" + i + "]",args[i].toString());
            System.out.println("key: " + keyExpress);
        }
        return keyExpress;
    }
}
