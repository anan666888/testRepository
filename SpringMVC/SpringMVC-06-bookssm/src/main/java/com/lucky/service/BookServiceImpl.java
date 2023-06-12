package com.lucky.service;

import com.lucky.dao.BookMapper;
import com.lucky.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.pattern.PathPattern;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int addBook(Books books) {
        return 0;
    }

    @Override
    public int deleteBook(int id) {
        return 0;
    }

    @Override
    public int updateBook(Books books) {
        return 0;
    }

    @Override
    public Books queryBookById(int id) {
        return null;
    }

    @Override
    public List<Books> queryAllBook() {
        return null;
    }
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
}
