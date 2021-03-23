package com.atguigu.web;

import com.atguigu.bean.Manager;
import com.atguigu.bean.User;
import com.atguigu.service.ManagerService;
import com.atguigu.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManagerServlet extends BaseServlet {
    private ManagerService managerService=new ManagerServiceImpl();
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Manager login = managerService.login(new Manager(null, username,password));
        if (login == null) {
            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);
//            response.sendRedirect("/pages/user/managerLogin.jsp");
            request.getRequestDispatcher("/pages/user/managerLogin.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("manager", login);
            session.setAttribute("user", null);
            session.setMaxInactiveInterval(60*5);
//            response.sendRedirect("/pages/user/manager.jsp");
            request.getRequestDispatcher("/pages/manager/manager.jsp").forward(request, response);
        }
    }
    protected void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }
}
