package com.example.springbootdruid.service;

import com.example.springbootdruid.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {
    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     * @param userName
     * @return
     */
    User findByName(String userName);
}
