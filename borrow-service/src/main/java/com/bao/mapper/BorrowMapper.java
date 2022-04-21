package com.bao.mapper;

import com.bao.entity.BorrowEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {

    @Select("select * from borrow where uid = #{uid}")
    List<BorrowEntity> getBorrowByUid(int uid);



}
