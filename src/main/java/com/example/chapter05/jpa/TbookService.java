package com.example.chapter05.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbookService {

    @Autowired
    private TbookDao tbookDao;

    public List<Tbook> getAllTbook(){
        //List<Tbook> bookList = tbookDao.findAll();
        List<Tbook> bookList = tbookDao.findAll(Sort.by(Sort.Order.desc("id")));
        return bookList;
    }

    public Page<Tbook> findBookByPage(Pageable pageable){
        Page<Tbook> page = tbookDao.findAll(pageable);
        return  page;
    }

    public List<Tbook> findByBookName(String name){
        return tbookDao.findByName(name);
    }

    public List<Tbook> findByBookAuthor(String autor){
        return tbookDao.findByAuthorContains(autor);
    }
    public List<Tbook> getPriceBetween(Float min,Float max){
        return tbookDao.getPriceBetween(min,max);
    }

}
