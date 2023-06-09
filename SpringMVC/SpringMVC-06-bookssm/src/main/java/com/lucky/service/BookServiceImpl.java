package com.lucky.service;

import com.lucky.dao.BookMapper;
import com.lucky.pojo.Books;

public class BookServiceImpl implements BookService {
    //调用dao层的操作，设置一个set接口，方便spring的管理
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }
}
