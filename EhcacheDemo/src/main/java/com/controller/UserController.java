package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    CacheManager cacheManager;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/adduser")
    public int addUser(){
        User user = new User();
        user.setUserName("John");
        user.setUserAge(23);
        return userService.addUser(user);
    }

    @RequestMapping(value = "/getusersbyname",method = RequestMethod.POST)
    public List<User> getUsersByName(@RequestBody User user){
        System.out.println("---------------------------------------");
        System.out.println("call / getusersbyname");
        System.out.println(cacheManager.toString());
        List<User> users = userService.getUsersByName(user.getUserName());
        return users;
    }
}
