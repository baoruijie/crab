package com.bao.serviceImpl;

import com.bao.entity.BookEntity;
import com.bao.service.ReturnBookService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ReturnBookServiceImpl implements ReturnBookService {


    @Override
    public BookEntity returnBookById(int id) {

        RestTemplate restTemplate = new RestTemplate();
        BookEntity book = restTemplate.getForObject("http://localhost:8001/book/return/"+id,BookEntity.class);

        return book;
    }
}
