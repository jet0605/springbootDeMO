package com.example.springbootshiro.config;

import com.example.springbootshiro.domain.User;

import java.util.*;

/**
 * @author Jet
 */
public class DBCache {
    /**
     * k 用户名
     * v 用户信息
     */
    public static final Map<String,User> USERS_CACHE = new HashMap<>();
    /**
     * k 角色Id
     * v 权限编码
     */
    public static final Map<String,Collection<String>> PERMISSIONS_CACHE = new HashMap<>();

    static{
        //模拟数据
        USERS_CACHE.put("u1",new User(1L,"u1","p1","admin",true));
        USERS_CACHE.put("u2",new User(2L,"u2","p2","admin",false));
        USERS_CACHE.put("u3",new User(3L,"u3","p3","test",true));

        PERMISSIONS_CACHE.put("admin", Arrays.asList("user:list","user:add","user:edit"));
        PERMISSIONS_CACHE.put("test", Collections.singleton("user:list"));
    }
}
