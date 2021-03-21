package com.atguigu.service;

import com.atguigu.bean.User;

public interface UserService {
    void registerUser(User user);
    User login(User user);
    boolean existUserName(String username);
}
