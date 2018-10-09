package com.zhaoyu.spingbootsecurity.practice1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping
    public String login() {
        return "login";
    }
}
