package com.example.repetitioncommitdemoone.controller;

import com.example.repetitioncommitdemoone.annotation.LocalLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookController
 * @author Jet
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @LocalLock(key = "book:arg[0]")//取arg[0]为book
    @GetMapping
    public String query(@RequestParam String token){
        return "success -" + token;
    }
}
