package com.atguigu.service;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;

import java.util.List;

public interface OrderService {
    String createOrder(Cart cart,Integer userId);
    List<Order> showMyOrders(int userId);
    /**
     * 通过订单号查询该订单的商品详情
     * @param orderId  订单号
     * @return         该订单的商品信息
     */
    List<OrderItem> showOrderDetail(String orderId);

    /**
     * 管理员查询所有订单
     * @return  所有订单
     */
    List<Order> showAllOrders();

    /**
     * 管理员发货
     * @param orderId  订单号
     */
    void sendOrder(String orderId);

    /**
     * 客户签收订单
     * @param orderId  订单号
     */
    void signOrder(String orderId);

    /**
     * 支付
     * @param orderId
     */
    void payOrder(String orderId);
}
