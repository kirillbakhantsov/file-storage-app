package com.example.filestorage.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping
    public String testPost() {
        return "POST request successful";
    }

    @GetMapping
    public String testGet() {
        return "GET request successful";
    }
}