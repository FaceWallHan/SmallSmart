package com.atguigu.dao.impl;

import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderDao;

import java.util.List;

public class OrderDaoImpl  extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql="INSERT INTO `book`.`t_order` (`order_id`, `create_time`, `price`, `status`, `user_id`) VALUES (?, ?, ?, ?, ?)";
        return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer userId) {
        String sql="select `order_id` orderId,create_time createTime,price,status,`user_id` userId from t_order where `user_id`=?";
        return queryForList(Order.class, sql, userId);
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select order_id orderId,create_time createTime,price,status,user_id userId from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public void updateStatus(String orderId, String status) {
        String sql="update t_order set status = ? where order_id = ?";
        update(sql,status,orderId);
    }

}
