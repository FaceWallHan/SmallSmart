package com.atguigu.dao;

import com.atguigu.bean.Manager;

public interface ManagerDao {
    Manager queryUserByUserNameAndPassword(String username, String password);
}
