package com.atguigu.filter;

import com.atguigu.util.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JdbcUtils.rollBackAndClose();//回滚事务
            throw new RuntimeException(e);//把异常抛给Tomcat管理展示友好的错误页面
        }
    }
}
