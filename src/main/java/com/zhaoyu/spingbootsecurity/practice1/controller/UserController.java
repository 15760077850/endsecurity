package com.zhaoyu.spingbootsecurity.practice1.controller;


import com.zhaoyu.spingbootsecurity.practice1.domain.User;
import com.zhaoyu.spingbootsecurity.practice1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/index")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String toIndex(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/index";
    }
}
