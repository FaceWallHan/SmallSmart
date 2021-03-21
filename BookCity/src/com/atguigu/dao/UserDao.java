package com.atguigu.dao;

import com.atguigu.bean.User;

public interface UserDao {
    User queryUserByUserName(String username);
    User queryUserByUserNameAndPassword(String username,String password);
    int saveUser(User user);
}
