package com.mufan.custompackage.service;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 14:09 2019/1/16
 * @ Description：用户的业务层
 * % @author YuXingZh
 */
public interface UserService {
    /**
     * @Description: 验证openId是否有授权过
     * @Param: openId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    boolean verify(String openId);

    /**
     * @Description: 验证openId是否有授权过
     * @Param: openId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    void grant(String openId,String userName);

    /**
     * @Description: 获取userId
     * @Param: openId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    int getUserId(String openId);
}
