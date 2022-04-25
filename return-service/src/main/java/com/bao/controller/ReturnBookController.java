package com.bao.controller;

import com.bao.entity.BookEntity;
import com.bao.service.ReturnBookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ReturnBookController {

    //这个是压测用的
    static int i = 0;


    @Resource
    private ReturnBookService returnBookService;


    @RequestMapping("/return/{bid}")
    public BookEntity returnBookById(@PathVariable("bid") int bid, HttpServletRequest request){
        System.out.println("还书。。。" + i++);
        BookEntity bookEntity = returnBookService.returnBookById(bid);

        return bookEntity;
    }
}
