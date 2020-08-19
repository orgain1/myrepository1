package com.example.chapter05.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addBook(Book book){
        int count = jdbcTemplate.update("insert into book(name,author) values(?,?)",book.getName(),book.getAuthor());
        return count;
    }

    public Book getBookById(int id){
        Book book = jdbcTemplate.queryForObject("select * from book where id = ?",new BeanPropertyRowMapper<>(Book.class),id);
        return book;
    }

    public List<Book> getBooks(){
        List<Book> bookList = jdbcTemplate.query("select * from book",new BeanPropertyRowMapper<>(Book.class));
        return bookList;
    }
}
