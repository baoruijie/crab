package com.bao.vo;

import com.bao.query.PageQuery;
import lombok.Data;

import java.util.Date;

@Data
public class BookVo extends PageQuery {
    Integer id;
    String bookName;
    String bookDesc;
    String location;
    String state;
    Date borrowtime;
}
