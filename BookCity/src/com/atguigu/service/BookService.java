package com.atguigu.service;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    void deleteById(Integer id);
    void updateBook(Book book);
    Book queryBookId(Integer id);
    List<Book> queryBooks();
    Page<Book> page(int pageNo,int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
