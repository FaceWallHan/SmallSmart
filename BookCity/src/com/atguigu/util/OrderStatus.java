package com.atguigu.util;

public enum OrderStatus {
    PAYMENT("待支付",0),
    SHIP("待发货",1),
    ARRIVE("待收货",2),
    SIGNED("已签收",3);
    private String type;
    private int typeId;
    private OrderStatus(String type,int typeId) {
        this.type=type;
        this.typeId=typeId;
    }
}
