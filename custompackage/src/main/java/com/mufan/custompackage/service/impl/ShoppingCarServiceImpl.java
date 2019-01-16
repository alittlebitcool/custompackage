package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.ShoppingCarMapper;
import com.mufan.custompackage.entity.ShoppingCar;
import com.mufan.custompackage.entity.Trolley;
import com.mufan.custompackage.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：购物车类service
 * % @author YuXingZh
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;


    /**
     * @Description: 加入购物车
     * @Param: shoppingCar
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void insertShoppingCar(ShoppingCar shoppingCar) {
        shoppingCarMapper.insertSelective(shoppingCar);
    }

    /**
     * @Description: 移除购物车
     * @Param: shoppingCarId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void removeShoppingCar(int shoppingCarId) {
        shoppingCarMapper.deleteByPrimaryKey(shoppingCarId);
    }

    /**
     * @Description: 变更购物车数量
     * @Param: shoppingCarId, num
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void editShoppingCar(int shoppingCarId, int num) {
        ShoppingCar shoppingCar =
                shoppingCarMapper.selectByPrimaryKey(shoppingCarId);
        shoppingCar.setNum(num);
        shoppingCarMapper.updateByPrimaryKeySelective(shoppingCar);
    }

    /**
     * @Description: 查询当前用户的所有购物车 默认购物车
     * @Param: userId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public List<Trolley> getAll(int userId) {
        return shoppingCarMapper.getAll(userId);
    }
}
