package com.bao.query;

import lombok.Data;


@Data
public class PageQuery {
    private Integer page = 1;
    private Integer size = 10;
    private Integer total;



}
