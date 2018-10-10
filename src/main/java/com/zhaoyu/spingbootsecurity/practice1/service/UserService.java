package com.zhaoyu.spingbootsecurity.practice1.service;

import com.zhaoyu.spingbootsecurity.practice1.domain.User;

public interface UserService {
    public User login(User user);

    public User findUserByName(String name);
}
