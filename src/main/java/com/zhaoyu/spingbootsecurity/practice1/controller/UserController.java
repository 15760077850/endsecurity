package com.zhaoyu.spingbootsecurity.practice1.controller;


import com.zhaoyu.spingbootsecurity.practice1.domain.User;
import com.zhaoyu.spingbootsecurity.practice1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/index")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String toIndex(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/index";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return "/index";
    }
    @GetMapping("/{id}")
    public String getUser(Model model,@PathVariable Long id) {
        System.out.println("jinglia");
//        User user = userRepository.findById(id);

//        model.addAttribute("one", user);
        return "userInfo";
    }

}
