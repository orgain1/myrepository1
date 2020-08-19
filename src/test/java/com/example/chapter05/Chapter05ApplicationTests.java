package com.example.chapter05;


import com.example.chapter05.jdbc.Book;
import com.example.chapter05.jdbc.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Chapter05ApplicationTests {

    @Autowired
    private BookService bookService;




    @Test
    public void testAddBook(){
        Book book = new Book();
        book.setName("springBook 开发指南");
        book.setAuthor("admin");
        int count = bookService.addBook(book);
        System.out.println("count : "+count);
    }

    @Test
    public void testGetBookById(){
        Book book = bookService.getBookById(1);
        System.out.println(book.getId() +"\t"+book.getName());
    }

    @Test
    public void testGetBooks(){
        List<Book> bookList = bookService.getBooks();
        for(Book book : bookList) {
            System.out.println(book.getId() + "\t" + book.getName());
        }
    }
}
