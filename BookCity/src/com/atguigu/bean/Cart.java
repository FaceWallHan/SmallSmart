package com.atguigu.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    //key是商品编号，value是商品信息
    private Map<Integer,CartItem> itemMap=new LinkedHashMap<>();
    public void deleteItem(Integer id){
        itemMap.remove(id);
    }
    public void updateCount(Integer id,Integer count){
        CartItem cartItem = itemMap.get(id);
        if (cartItem!=null){
            cartItem.setCount(count);
            cartItem.setPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));//更新总金额
        }
    }
    public void clear(){
        itemMap.clear();
    }
    public void addItem(CartItem cartItem){
//        先查看购物车中是否已经添加过此商品，如果已添加，则数量累加，总金额更新，如果没有添加过，直接放到集合中即可
        CartItem item = itemMap.get(cartItem.getId());
        if (item==null){
            itemMap.put(cartItem.getId(), cartItem);
        }else {
            item.setCount(cartItem.getCount()+1);//数量累计
            item.setPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        }
    }

    public Cart() {
    }

    public Integer getTotalCount() {
        Integer totalCount=0;
        for (Map.Entry<Integer, CartItem> entry : itemMap.entrySet()) {
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice=new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : itemMap.entrySet()) {
            totalPrice=totalPrice.add(entry.getValue().getPrice());
        }
        return totalPrice;
    }
    public Map<Integer, CartItem> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, CartItem> itemMap) {
        this.itemMap = itemMap;
    }
    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + itemMap +
                '}';
    }
}
