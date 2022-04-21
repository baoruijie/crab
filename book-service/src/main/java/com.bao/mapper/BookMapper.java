package com.bao.mapper;

import com.bao.entity.BookEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {


    @Select("SELECT * FROM BOOK WHERE ID=#{id}")
    BookEntity getBookInfoById(int id);

}
