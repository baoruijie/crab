package com.bao.serviceImpl;

import com.bao.entity.BookEntity;
import com.bao.mapper.BookMapper;
import com.bao.service.BookService;
import com.bao.vo.BookVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookEntity> implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public IPage<BookEntity> queryPage(BookVo vo) {
        QueryWrapper<BookEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("location","a");
        queryWrapper.and(QueryWrapper ->
                QueryWrapper.like("state",vo.getState())
                        .or().like("state",vo.getState()));

        IPage<BookEntity> page = this.page(new Page<BookEntity>(vo.getPage(),vo.getSize()),queryWrapper);
        return page;
    }

    @Override
    public BookEntity getBookInfoById(int id) {
        return bookMapper.getBookInfoById(id);
    }
}
