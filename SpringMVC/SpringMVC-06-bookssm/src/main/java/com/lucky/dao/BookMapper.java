package com.lucky.dao;

import com.lucky.pojo.Books;

import java.util.List;

public interface BookMapper {

    //增加一个Book
    int addBook(Books books);
    //根据id删除一个Book
    int deleteBook(int id);
    //更新book
    int updateBook(Books books);
    //根据id查询，返回一个book
    Books queryBookById(int id);
    //查询全部Book，返回list集合
    List<Books> queryAllBook();
}
