package com.atguigu.dao.impl;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDao;

import java.util.List;

public class OrderItemDaoImpl  extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="INSERT INTO `book`.`t_order_item` (`name`, `count`, `price`, `total_price`, `order_id`) VALUES (?, ?, ?, ?, ?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOderItemByOrderId(String orderId) {
        String sql="select name,count,price,total_price totalPrice from t_order_item where order_id =?";
        return queryForList(OrderItem.class, sql, orderId);
    }
}
