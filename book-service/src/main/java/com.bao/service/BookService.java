package com.bao.service;

import com.bao.entity.BookEntity;
import com.bao.vo.BookVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface BookService {

    IPage<BookEntity> queryPage(BookVo bookVo);
    BookEntity getBookInfoById(int id);

}
