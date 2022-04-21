package com.bao.controller;


import com.bao.entity.UserBorrowEntity;
import com.bao.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BorrowController {

    @Resource
    BorrowService borrowService;

    @RequestMapping("/borrow/{uid}")
    UserBorrowEntity findUserBorrows(@PathVariable("uid") int uid){
        return borrowService.getUserBorrowInfoByUid(uid);
    }
}
