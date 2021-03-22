package com.atguigu.web;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    private OrderService orderService=new OrderServiceImpl();
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数 用户ID
        User user = (User) req.getSession().getAttribute("user");
        //登录的情况
        if(user != null) {
            //查看
            List<Order> orderList = orderService.showMyOrders(user.getId());
            //回传数据
            req.setAttribute("orderList", orderList);
            //返回页面
            req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
        }else{
            //未登录的情况下
            //返回页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }
    /**
     * 签收订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void signOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单号
        String orderId = req.getParameter("orderId");
        //获取用户
        User user= (User) req.getSession().getAttribute("user");
        //签收订单
        orderService.signOrder(orderId);
        //查看
        List<Order> orderList = orderService.showMyOrders(user.getId());
        //回传数据
        req.setAttribute("orderList", orderList);
        //返回页面
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User loginUser = (User) request.getSession().getAttribute("user");
        if (loginUser==null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = loginUser.getId();
        String orderId = orderService.createOrder(cart, userId);
        request.getSession().setAttribute("orderId", orderId);
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
    /**
     * 查看该订单详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数 订单号
        String orderId = req.getParameter("orderId");
        //查看
        List<OrderItem> orderItemList = orderService.showOrderDetail(orderId);
        //回传数据
        req.setAttribute("orderItemList", orderItemList);
        //返回页面
        for (OrderItem item : orderItemList) {
            System.out.println(item);
        }
        System.out.println("orderId:"+orderId);
        req.getRequestDispatcher("/pages/order/order_detail.jsp").forward(req, resp);
    }
    /**
     * 管理员查看所有订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看
        List<Order> allOrder = orderService.showAllOrders();
        //回传数据
        req.setAttribute("allOrder", allOrder);
        //返回页面
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }
    /**
     * 发货
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单号
        String orderId = req.getParameter("orderId");
        //发货
        orderService.sendOrder(orderId);
        //查新最新数据
        List<Order> allOrder = orderService.showAllOrders();
        //回传数据
        req.setAttribute("allOrder", allOrder);
        //返回页面
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }
    /**
     * 支付
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void payOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取订单号
        String orderId = req.getParameter("orderId");
        //支付
        orderService.payOrder(orderId);
        //获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null) {
            //支付完的东西清空购物车
            req.getSession().removeAttribute("cart");
        }
        //回传数据
        req.getSession().setAttribute("orderId", orderId);
        //返回页面
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
    }
}
