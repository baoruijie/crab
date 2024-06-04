package com.bao.controller;


import com.bao.entity.BookEntity;
import com.bao.service.BookService;
import com.bao.vo.BookVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {


    @Resource
    private BookService bookService;

    @RequestMapping("booklist/{beginPage}/{pagesize}")
    public IPage<BookEntity> getList(@PathVariable("beginPage") String beginPage, @PathVariable("pagesize") String pagesize){
        BookVo vo = new BookVo();
        vo.setPage(Integer.valueOf(beginPage));
        vo.setSize(Integer.valueOf(pagesize));
        vo.setLocation("");
        vo.setState("");

        return  bookService.queryPage(vo);
    }

    @RequestMapping("/book/{id}")
    public BookEntity findBookInfoById(@PathVariable("id") int id){
        return bookService.getBookInfoById(id);
    }

    @RequestMapping("/test")
    public String test1(){
        return "test";
    }
    @RequestMapping("/test/test")
    public String test2(){
        return "test/test";
    }

    @RequestMapping("/book")
    public String one(){
        return "132352315";
    }

}
