package com.atguigu.dao.impl;

import com.atguigu.bean.Manager;
import com.atguigu.bean.User;
import com.atguigu.dao.ManagerDao;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {
    @Override
    public Manager queryUserByUserNameAndPassword(String username, String password) {
        String sql="select id,username,password from t_manager where username =? and password =?";
        return queryForOne(Manager.class, sql, username,password);
    }
}
