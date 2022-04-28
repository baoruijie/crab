package com.bao.mapper;

import com.bao.entity.BookEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
//mybatis-plus需要继承BaseMapper，并指定实体类类型，与数据库表对应，且配置文件开启驼峰转换。
public interface BookMapper extends BaseMapper<BookEntity> {


    @Select("SELECT * FROM BOOK WHERE ID=#{id}")
    BookEntity getBookInfoById(int id);

}
