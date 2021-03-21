package com.atguigu.bean;

import java.math.BigDecimal;

public class Book {
    private Integer id,sales,stock;
    private String name,author,imgPath="static/img/default.jpg";
    private BigDecimal price;

    public Book(Integer id, Integer sales, Integer stock, String name, String author, String img, BigDecimal price) {
        this.id = id;
        //销量
        this.sales = sales;
        //库存
        this.stock = stock;
        this.name = name;
        this.author = author;
        if (img!=null&&!"".equals(img)){
            this.imgPath = imgPath;
        }
        this.price = price;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String img) {
        if (img!=null&&!"".equals(img)){
            this.imgPath = img;
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", sales=" + sales +
                ", stock=" + stock +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", price=" + price +
                '}';
    }
}
