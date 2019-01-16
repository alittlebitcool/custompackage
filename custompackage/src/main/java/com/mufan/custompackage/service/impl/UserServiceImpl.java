package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：用户类service
 * % @author YuXingZh
 */
@Service
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;
}
