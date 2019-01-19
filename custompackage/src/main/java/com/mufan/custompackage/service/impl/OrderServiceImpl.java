package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.AddressMapper;
import com.mufan.custompackage.dao.GoodMapper;
import com.mufan.custompackage.dao.OrderMapper;
import com.mufan.custompackage.dao.PartMapper;
import com.mufan.custompackage.entity.Address;
import com.mufan.custompackage.entity.Good;
import com.mufan.custompackage.entity.OrderDetail;
import com.mufan.custompackage.service.OrderService;
import com.mufan.custompackage.util.EntityConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private PartMapper partMapper;

    @Autowired
    private AddressMapper addressMapper;

    /**
     * @Description: 获取所有订单状态信息
     * @Param: userId
     * @return: map
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Override
    public Map<String, Integer> getAllStatus(int userId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("pendingPayment", orderMapper.pendingPayment(userId));
        map.put("pendingDelivery", orderMapper.pendingDelivery(userId));
        map.put("pendingGain", orderMapper.pendingGain(userId));
        map.put("pendingEvaluated", orderMapper.pendingEvaluated(userId));
        return map;
    }

    /**
     * @Description: 立即购买加入订单
     * @Param: partsId,num,userId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @Override
    public Map<String, Object> purchaseImmediate(List<Integer> partsId, int num, int userId) {
        Map<String, Object> map = new HashMap<>();
        // 查出物品
        int goodId =
                orderMapper.getGoodId(EntityConversion.getGoodId(partsId));
        Good good = goodMapper.selectByPrimaryKey(goodId);
        map.put("good",goodMapper.selectByPrimaryKey(goodId));
        map.put("num",num);

        // 得到默认地址
        Address address = addressMapper.getDefaultAddress(userId);
        map.put("defaultAddress", address);

        // 查出部件名称
        for (int i = 0;i < 3;i++) {
            map.put("part" + (i+1), partMapper.getPartName(partsId.get(i)));
        }

        // 得出物品总价
        Double goodPrice = good.getPrice() * num;
        map.put("totalPrice",goodPrice);

        // 物品运费
        Double freight = address.getFreight();
        map.put("freight",freight);

        // 得出实际支付加运费
        Double realPay = goodPrice + address.getFreight();
        map.put("realPay",realPay);

        return map;
    }

    /**
     * @Description: 取消订单
     * @Param: orderId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @Override
    public void cancelOrder(int orderId) {
        // 设置状态为6已关闭
        orderMapper.setStatus(orderId,6);

        // 设置交易关闭时间
        orderMapper.setCloseTime(orderId);
    }

    /**
     * @Description: 确认收获 交易完成
     * @Param: orderId
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @Override
    public void harvestConfirm(int orderId) {
        // 设置状态为4待评价
        orderMapper.setStatus(orderId,4);

        // 设置交易完成时间
        orderMapper.setEndTime(orderId);
    }

    /**
     * @Description: 评价订单
     * @Param: orderId
     * @return: text
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @Override
    public void orderEvaluate(int orderId, String text) {
        // 设置状态为6已关闭
        orderMapper.setStatus(orderId,5);

        // 添加评论
        orderMapper.orderEvaluate(orderId,text);
    }

    /**
     * @Description: 获取全部的订单信息
     * @Param: userId
     * @return: text
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @Override
    public List<OrderDetail> getAll(int userId) {
        return orderMapper.getAll(userId);
    }

}
