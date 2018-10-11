package com.zhaoyu.spingbootsecurity.practice1.controller;


import com.zhaoyu.spingbootsecurity.practice1.domain.User;
import com.zhaoyu.spingbootsecurity.practice1.repository.UserRepository;
import com.zhaoyu.spingbootsecurity.practice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/index")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public String toIndex(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/index";
    }

//    @PostMapping("/toindex")
//    public ModelAndView loginEnd(User user) {
//
//        User user2 = userService.login(user);
//        if (user2 != null) {
//            return new ModelAndView("redirect:/index", "loginUser", user2);
//        }
//
//        return new ModelAndView("login", "loginFail", "登录失败");
//    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
        return "redirect:/index";
    }
    @GetMapping("/{id}")
    public String getUser(Model model,@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        model.addAttribute("one", user);
        return "/userInfo";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userRepository.save(user);
        System.out.println("保存了");
        return "redirect:/index";
    }

    @GetMapping("/touserForm")
    public String addUser() {
        return "/userForm";
    }
}
