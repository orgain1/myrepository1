package com.example.chapter05;

import com.example.chapter05.jpa.Tbook;
import com.example.chapter05.jpa.TbookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TbookServiceTest {

    @Autowired
    private TbookService tbookService;

    @Test
    public void testGetAllTbook(){
        List<Tbook> bookList =  tbookService.getAllTbook();
        for(Tbook book : bookList){
            System.out.println(book.getId() +"\t"+book.getName());
        }
    }

    @Test
    public void testFindBookByPage(){
        Pageable pageable = PageRequest.of(1,2);

        Page<Tbook> page= tbookService.findBookByPage(pageable);
        Iterator<Tbook> tbooks = page.iterator();
        for (;tbooks.hasNext();){
            Tbook book = tbooks.next();
            System.out.println(book.getId() +"\t"+book.getName());
        }
    }

    @Test
    public void testFindByBookName(){
        List<Tbook> tbooks =  tbookService.findByBookName("红楼梦");
        for(Tbook book : tbooks){
            System.out.println("ID : "+book.getId() +"\t"+book.getName());
        }
    }

    @Test
    public void testFindByBookAuthor(){
        List<Tbook> tbooks =  tbookService.findByBookAuthor("鲁");
        for(Tbook book : tbooks){
            System.out.println("ID : "+book.getId() +"\t"+book.getName() +"\t"+book.getAuthor());
        }
    }

    @Test
    public void testGetPriceBetween(){
        List<Tbook> tbooks = tbookService.getPriceBetween(70f,100f);
        for(Tbook book : tbooks){
            System.out.println(book.getId() +"\t"+book.getName() +"\t"+book.getPrice());
        }
    }
}
