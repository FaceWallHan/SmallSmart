package com.atguigu.filter;

import com.atguigu.bean.Manager;
import com.atguigu.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        Manager manager = (Manager) request.getSession().getAttribute("manager");
        if (manager==null){
            request.getRequestDispatcher("/pages/user/managerLogin.jsp").forward(req, resp);
        }else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
