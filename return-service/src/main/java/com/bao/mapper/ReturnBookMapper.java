package com.bao.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ReturnBookMapper {

    @Update("UPDATE BOOK SET state = '1' WHERE ID = #{bid}")
    int returnBookId(int bid);
}
