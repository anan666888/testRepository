package com.lucky.service;

import com.lucky.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    //增加一个Book
    int addBook(Books books);

    //根据id删除一个Book
    int deleteBook(int id);

    //更新book
    int updateBook(Books books);

    //根据id查询一个book
    Books queryBookById(int id);

    //查询全部Book，返回list集合
    List<Books> queryAllBook();

}
