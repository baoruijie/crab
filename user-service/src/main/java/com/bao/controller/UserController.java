package com.bao.controller;

import com.bao.entity.UserEntity;
import com.bao.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/user/{id}")
    public UserEntity findUserById(@PathVariable("id") int id){
        System.out.println(id);
        return userService.getUserById(id);
    }
}
