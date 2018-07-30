package com.example.mybaitsdemo.mapper;

import com.example.mybaitsdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    /**
     * 根据用户查询用户结果集
     * @param userName 用户名
     * @return 查询结果
     */
    @Select("select * from t_user where username = #{username}")
    List<User> findByUsername(@Param("username") String userName);
    /**
     * 保存用户信息
     * @param user 用户信息
     * @return 成功1 失败0
     */
    int insert(User user);
}
