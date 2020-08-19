package com.example.chapter05.mybatis;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BooksController {

    @Resource
    private BooksService booksService;

    @RequestMapping(value = "/getAllBooks")
    public ModelAndView getAllBooks(
            @RequestParam(value = "pageNum",defaultValue = "0")
            int pageNum,
            @RequestParam(value = "size", defaultValue = "2")
            int size){
        ModelAndView view = new ModelAndView();
        PageHelper.startPage(pageNum,size," id desc ");

        List<Books> booksList = booksService.getAllBooks();
        PageInfo<Books> pageInfo = new PageInfo<>(booksList);

        //view.addObject("booksList",booksList);
        view.addObject("pageInfo",pageInfo);
        view.setViewName("list");
        return view;
    }
}
