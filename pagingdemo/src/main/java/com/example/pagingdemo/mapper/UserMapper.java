package com.example.pagingdemo.mapper;

import com.example.pagingdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;
@Mapper
@Component(value = "userMapper")
public interface UserMapper extends BaseMapper<User> {
    /**
     * @param userName
     * @return 统计结果
     */
    int countByUsername(String userName);
}
