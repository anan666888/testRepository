package com.lucky.dao;

import com.lucky.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加一个Book
    int addBook(Books books);

    //根据id删除一个Book
    int deleteBook(@Param("bookID") int id);

    //更新book
    int updateBook(Books books);

    //根据id查询一个book
    Books queryBookById(@Param("bookID") int id);

    //查询全部Book，返回list集合
    List<Books> queryAllBook();

}
