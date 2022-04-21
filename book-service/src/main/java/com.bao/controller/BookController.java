package com.bao.controller;


import com.bao.entity.BookEntity;
import com.bao.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {


    @Resource
    private BookService bookService;


    @RequestMapping("/book/{id}")
    public BookEntity findBookInfoById(@PathVariable("id") int id){
        return bookService.getBookInfoById(id);
    }

}
