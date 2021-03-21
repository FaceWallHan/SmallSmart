package com.atguigu.dao;

import com.atguigu.bean.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book);
    int deleteById(Integer id);
    int updateBook(Book book);
    Book queryBookId(Integer id);
    List<Book> queryBooks();

    int queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);


    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
