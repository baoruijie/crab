package com.bao.serviceImpl;

import com.bao.entity.UserEntity;
import com.bao.mapper.UserMapper;
import com.bao.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserEntity getUserById(int id) {
        System.out.println("UserServiceImpl" + id);
        return userMapper.getUserById(id);
    }
}
