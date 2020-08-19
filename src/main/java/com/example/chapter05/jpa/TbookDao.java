package com.example.chapter05.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbookDao extends JpaRepository<Tbook,Integer> {


    public List<Tbook> findByName(String name);

    public List<Tbook> findByAuthorContains(String author);


    @Query("select t from t_book t where t.price >= ?1 and t.price <= ?2")
    public List<Tbook> getPriceBetween(Float min,Float max);

}
