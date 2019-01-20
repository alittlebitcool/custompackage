package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.UserMapper;
import com.mufan.custompackage.entity.User;
import com.mufan.custompackage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：用户类service
 * % @author YuXingZh
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @Description: 验证openId是否有授权过
     * @Param: openId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    @Override
    public boolean verify(String openId) {
        return userMapper.existsOpenId(openId) == 1;
    }

    /**
     * @Description: 验证openId是否有授权过
     * @Param: openId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    @Override
    public void grant(String openId,String userName) {
        User user = new User();
        user.setOpenId(openId);
        user.setUserName(userName);
        userMapper.insertSelective(user);
    }
}
