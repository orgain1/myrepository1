package com.example.chapter05.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BooksMapper {

    public List<Books> getAllBooks();
}
