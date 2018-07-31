package com.example.springbootdruid.dao.master;

import com.example.springbootdruid.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "userDao")
public interface UserDao {
    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    User findByName(@Param("userName") String userName);
}
