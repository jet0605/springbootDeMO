package com.example.springbootswagger2demo.controller;

import com.example.springbootswagger2demo.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Api("用户信息管理")
@RestController
@RequestMapping("/user/*")
public class UserController {
    private final static List<User> userList = new ArrayList<>();
    {
        userList.add(new User("1","admin","123456"));
        userList.add(new User("2","jet","123456"));
    }
    @ApiOperation("获取列表")
    @GetMapping("list")
    public List userList(){
        return userList;
    }

    @ApiOperation("新增用户")
    @PostMapping("save")
    public boolean save(User user){
        return userList.add(user);
    }

    @ApiOperation("跟新用户")
    @ApiImplicitParam(name = "user",value = "单个用户信息",dataType = "User")
    @PutMapping("update")
    public boolean update(User user){
        return userList.remove(user) && userList.add(user);
    }
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "users",value = "N个用户信息",dataType = "List<User>")
    @DeleteMapping("delete")
    public boolean delete(@RequestBody List<User> users){
        return userList.removeAll(users);
    }
}
