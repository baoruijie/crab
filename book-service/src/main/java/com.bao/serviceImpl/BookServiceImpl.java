package com.bao.serviceImpl;

import com.bao.entity.BookEntity;
import com.bao.mapper.BookMapper;
import com.bao.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public BookEntity getBookInfoById(int id) {
        return bookMapper.getBookInfoById(id);
    }
}
