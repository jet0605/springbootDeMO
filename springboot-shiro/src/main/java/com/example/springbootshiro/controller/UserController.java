package com.example.springbootshiro.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public String get(){
        return "get...";
    }
    /**
     * RequiresRole 是所需角色 包含AND 和 OR 两种
     * RequiresPermissions 是所需权限 包含AND和OR两种
     * @return msg
     */
    @RequiresRoles(value = {"admin","test"},logical = Logical.OR)
    //@RequiresPermissions(value={"user:list,"user:query",logical = logical.OR"})
    @GetMapping("/query")
    public String query(){
        return "query...";
    }
    @GetMapping("/find")
    public String find(){
        return "find.....";
    }
}