package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    List<User> getUsers();

    int addUser(User user);

    List<User> getUsersByName( String userName );
}
