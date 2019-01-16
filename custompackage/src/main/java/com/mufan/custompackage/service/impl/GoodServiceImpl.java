//package com.mufan.custompackage.service.impl;
//
//import com.mufan.custompackage.dao.GoodMapper;
//import com.mufan.custompackage.entity.Good;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
///**
// * @ Author     ：zyx.
// * @ Date       ：Created in 16:45 2019/1/14
// * @ Description：商品类service
// * % @author YuXingZh
// */
//@Service
//public class GoodService {
//
//    @Autowired
//    private GoodMapper goodMapper;
//
//    /**
//     * @Description: 自定义添加物品
//     * @Param: shoppingCar
//     * @return: null
//     * @Author: YuXingZh
//     * @Date: 2019/1/14
//     */
//    public void insertGood(Good shoppingCar) {
//        goodMapper.insertSelective(shoppingCar);
//    }
//
//    /**
//     * @Description: 移除购物车
//     * @Param: shoppingCarId
//     * @return: null
//     * @Author: YuXingZh
//     * @Date: 2019/1/14
//     */
//    public void removeGood(int shoppingCarId) {
//        goodMapper.deleteByPrimaryKey(shoppingCarId);
//    }
//
//    /**
//     * @Description: 变更购物车数量
//     * @Param: shoppingCarId, num
//     * @return: null
//     * @Author: YuXingZh
//     * @Date: 2019/1/14
//     */
//    @RequestMapping("edit")
//    public void editGood(int shoppingCarId, int num) {
//        Good shoppingCar =
//                goodMapper.selectByPrimaryKey(shoppingCarId);
//        shoppingCar.setNum(num);
//        goodMapper.updateByPrimaryKeySelective(shoppingCar);
//    }
//
//    /**
//     * @Description: 查询当前用户的所有购物车 默认购物车
//     * @Param: userId
//     * @return: null
//     * @Author: YuXingZh
//     * @Date: 2019/1/14
//     */
//    public List<Good> getAll(int userId) {
//        Good shoppingCar = new Good();
//        shoppingCar.setUserId(userId);
//        return goodMapper.select(shoppingCar);
//    }
//}
