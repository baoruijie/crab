package com.bao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@TableName("book")
@Data
public class BookEntity {

    Integer id;
    String bookname;
    String bookdesc;
    String location;
    String state;
    Date borrowtime;
}
