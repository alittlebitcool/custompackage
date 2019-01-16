package com.mufan.custompackage.service;

import com.mufan.custompackage.dao.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 14:08 2019/1/16
 * @ Description：订单的业务层
 * % @author YuXingZh
 */
public interface OrderService {

    /**
     * @Description: 获取所有订单状态信息
     * @Param: userId
     * @return: map
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    public Map<String,Integer> getAllStatus(int userId);
}
