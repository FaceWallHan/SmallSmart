package com.atguigu.bean;

import com.atguigu.util.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private String orderId;
    private LocalDateTime createTime;
    private BigDecimal price;
    //0未发货，1已发货，2表示已签收
    private Integer userId;
    private String status= OrderStatus.PAYMENT.toString();

    public Order() {
    }

    public Order(String orderId, LocalDateTime createTime, BigDecimal price, String status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
