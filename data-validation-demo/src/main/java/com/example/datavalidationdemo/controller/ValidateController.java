package com.example.datavalidationdemo.controller;

import com.example.datavalidationdemo.annotation.Datetime;
import com.example.datavalidationdemo.domain.Book;
import com.example.datavalidationdemo.groups.Groups;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * 参数校验
 * @author Jet
 */
@Validated
@RestController
public class ValidateController {
    @GetMapping("/test2")
    public String test2(@NotBlank(message = "name 不能为空") @Length(min = 2, max = 10, message = "name长度必须在{min} - {max}之间")String name){
        return "success";
    }

    @GetMapping("/test3")
    public String test3(@Validated Book book){
        return "success";
    }

    @GetMapping("/test")
    public String test(@Datetime(message = "您输入的格式错误，正确格式为：{format}")String date){
        return "success";
    }

    @GetMapping("/insert")
    public String insert(@Validated(value = Groups.Default.class) Book book){
        return "insert";
    }

    @GetMapping("/update")
    public String update(@Validated(value = {Groups.Default.class,Groups.Update.class})Book book){
        return "update";
    }
}
