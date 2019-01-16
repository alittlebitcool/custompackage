package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.OrderMapper;
import com.mufan.custompackage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：订单类service
 * % @author YuXingZh
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * @Description: 获取所有订单状态信息
     * @Param: userId
     * @return: map
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Override
    public Map<String,Integer> getAllStatus(int userId) {
        Map<String,Integer> map = new HashMap<>();
        map.put("待付款",orderMapper.pendingPayment(userId));
        map.put("待发货",orderMapper.pendingDelivery(userId));
        map.put("待收货",orderMapper.pendingGain(userId));
        map.put("待评价",orderMapper.pendingEvaluated(userId));
        return map;
    }
}
