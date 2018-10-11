package com.zhaoyu.spingbootsecurity.practice1.service.impl;

import com.zhaoyu.spingbootsecurity.practice1.domain.User;
import com.zhaoyu.spingbootsecurity.practice1.repository.UserRepository;
import com.zhaoyu.spingbootsecurity.practice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
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

}
