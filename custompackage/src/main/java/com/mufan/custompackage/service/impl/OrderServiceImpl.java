package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.AddressMapper;
import com.mufan.custompackage.dao.GoodMapper;
import com.mufan.custompackage.dao.OrderMapper;
import com.mufan.custompackage.dao.PartMapper;
import com.mufan.custompackage.entity.Address;
import com.mufan.custompackage.entity.Good;
import com.mufan.custompackage.service.OrderService;
import com.mufan.custompackage.util.EntityConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        map.put("待付款", orderMapper.pendingPayment(userId));
        map.put("待发货", orderMapper.pendingDelivery(userId));
        map.put("待收货", orderMapper.pendingGain(userId));
        map.put("待评价", orderMapper.pendingEvaluated(userId));
        return map;
    }

    /**
     * @Description: 立即购买加入订单
     * @Param:
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

}
