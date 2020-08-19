package com.example.chapter05.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public int addBook(Book book){
        return bookDao.addBook(book);
    }

    public Book getBookById(int id){
        return bookDao.getBookById(id);
    }

    public List<Book> getBooks(){
        return  bookDao.getBooks();
    }
}
