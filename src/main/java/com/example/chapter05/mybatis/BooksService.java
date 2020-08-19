package com.example.chapter05.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BooksService {

    @Resource
    private  BooksMapper booksMapper;

    public List<Books> getAllBooks(){
        List<Books> booksList = booksMapper.getAllBooks();
        return booksList;
    }
}
