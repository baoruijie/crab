package com.bao.serviceImpl;

import com.bao.mapper.ReturnBookMapper;
import com.bao.service.ReturnBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReturnBookServiceImpl implements ReturnBookService {

    @Resource
    ReturnBookMapper returnBookMapper;


    @Override
    public int returnBookById(int id) {

        return returnBookMapper.returnBookId(id);
    }
}
