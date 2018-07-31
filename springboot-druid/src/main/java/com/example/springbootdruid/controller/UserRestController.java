package com.example.springbootdruid.controller;

import com.example.springbootdruid.domain.User;
import com.example.springbootdruid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/api/user",method = RequestMethod.GET)
    public User findByName(@RequestParam(value = "userName",required = true) String userName){
        return userService.findByName(userName);
    }
}
