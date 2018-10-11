package com.zhaoyu.spingbootsecurity.practice1.service.impl;

import com.zhaoyu.spingbootsecurity.practice1.domain.User;
import com.zhaoyu.spingbootsecurity.practice1.repository.UserRepository;
import com.zhaoyu.spingbootsecurity.practice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService,UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User login(User user) {
        User user2 = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return user2;
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        if (user == null) throw new UsernameNotFoundException("Username " + s + " not found");
        return user;
    }
}
