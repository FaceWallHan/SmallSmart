package com.atguigu.dao;

import com.atguigu.bean.OrderItem;

import java.util.List;

public interface OrderItemDao {
    int saveOrderItem(OrderItem orderItem);
    /**
     *  通过订单号查询订单的详细商品信息
     * @param orderId    订单号
     * @return           订单的商品信息
     */
    List<OrderItem> queryOderItemByOrderId(String orderId);
}
