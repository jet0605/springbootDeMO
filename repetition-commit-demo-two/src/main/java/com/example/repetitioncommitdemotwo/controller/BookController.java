package com.example.repetitioncommitdemotwo.controller;

import com.example.repetitioncommitdemotwo.annotation.CacheLock;
import com.example.repetitioncommitdemotwo.annotation.CacheParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @CacheLock(prefix = "books")
    @GetMapping
    public String query(@CacheParam(name = "token") @RequestParam String token){
        return "success - " + token;
    }
}
