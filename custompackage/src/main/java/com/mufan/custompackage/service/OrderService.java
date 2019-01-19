package com.mufan.custompackage.service;

import com.mufan.custompackage.entity.OrderDetail;
import org.springframework.transaction.annotation.Transactional;

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
     * @Param: partsId，userId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @Transactional
    Map<String, Object> purchaseImmediate (List<Integer> partsId, int num, int userId);

    /**
     * @Description: 取消订单
     * @Param: orderId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @Transactional
    void cancelOrder(int orderId);

    /**
     * @Description: 交易完成
     * @Param: orderId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @Transactional
    void harvestConfirm(int orderId);

    /**
     * @Description: 评价订单
     * @Param: orderId
     * @return: text
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @Transactional
    void orderEvaluate(int orderId, String text);

    /**
     * @Description: 获取全部的订单信息
     * @Param: userId
     * @return: text
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    List<OrderDetail> getAll(int userId);

    /**
     * @Description: 立即购买
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/19
     */
    @Transactional
    void commit(Map<String, Object> map);
}
