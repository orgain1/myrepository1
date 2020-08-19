package com.example.chapter05.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    private  TbookService tbookService;

    @RequestMapping(value = "/getAllBook")
    public ModelAndView getAllBook(@RequestParam(value = "start",defaultValue = "0") Integer start ,@RequestParam(value = "limit", defaultValue = "2") Integer limit){

        ModelAndView view = new ModelAndView();

        Pageable  pageable = PageRequest.of(start,limit);
        Page<Tbook> page =  tbookService.findBookByPage(pageable);

        view.addObject("page",page);
        view.setViewName("bookList");
        return view;
    }
}
