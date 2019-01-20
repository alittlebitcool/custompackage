package com.mufan.custompackage.dao;

import com.mufan.custompackage.entity.Address;
import com.mufan.custompackage.entity.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：用户类mapper
 * % @author YuXingZh
 */
public interface UserMapper extends Mapper<User> {
    /**
     * @Description: 验证openId是否存储过
     * @Param: openId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    @Select("SELECT COUNT(*) FROM user where open_id = #{openId}")
    int existsOpenId(String openId);
}
