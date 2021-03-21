package com.atguigu.dao.impl;

import com.atguigu.bean.Book;
import com.atguigu.dao.BookDao;

import java.util.List;

public class BookDaoImpl  extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql="INSERT INTO `book`.`t_book` ( `name`, `price`, `author`, `sales`, `stock`, `img_path`) VALUES (?,?,?,?,?,?)";
        return update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteById(Integer id) {
        String sql="delete from t_book where id=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="UPDATE `book`.`t_book` SET `name`=?, `price`=?, `author`=?, `sales`=?, `stock`=?, `img_path`=? WHERE id=?";
        return update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookId(Integer id) {
        String sql="select `id`,`name`, `price`, `author`, `sales`, `stock`, `img_path` imgPath from t_book where id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select `id`,`name`, `price`, `author`, `sales`, `stock`, `img_path` imgPath from t_book";
        return queryForList(Book.class, sql );
    }

    @Override
    public int queryForPageTotalCount() {
        String sql="select count(*) from t_book";
        Number number = (Number) queryForSimpleValue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql="select `id`,`name`, `price`, `author`, `sales`, `stock`, `img_path` imgPath from t_book limit ?,?";
        return queryForList(Book.class, sql, begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql="select count(*) from t_book where price between ? and ?";
        Number number = (Number) queryForSimpleValue(sql,min,max);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql="select `id`,`name`, `price`, `author`, `sales`, `stock`, `img_path` imgPath from t_book where price between ? and ? order by price limit ?,?";
        return queryForList(Book.class, sql,min,max, begin,pageSize);
    }
}
