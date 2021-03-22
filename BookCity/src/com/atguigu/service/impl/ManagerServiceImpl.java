package com.atguigu.service.impl;

import com.atguigu.bean.Manager;
import com.atguigu.dao.ManagerDao;
import com.atguigu.dao.impl.ManagerDaoImpl;
import com.atguigu.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao=new ManagerDaoImpl();
    @Override
    public Manager login(Manager user) {
        return managerDao.queryUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }
}
