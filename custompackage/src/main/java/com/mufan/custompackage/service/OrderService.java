package com.mufan.custompackage.service;

import java.util.List;
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
    Map<String, Integer> getAllStatus(int userId);

    /**
     * @Description: 立即购买加入订单
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    void insertShoppingCar(List<Integer> partsId, int num, int userId);
}
