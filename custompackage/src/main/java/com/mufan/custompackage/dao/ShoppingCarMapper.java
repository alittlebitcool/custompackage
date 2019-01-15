package com.mufan.custompackage.dao;

import com.mufan.custompackage.entity.Address;
import com.mufan.custompackage.entity.ShoppingCar;
import com.mufan.custompackage.entity.Trolley;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：购物车类mapper
 * % @author YuXingZh
 */
public interface ShoppingCarMapper extends Mapper<ShoppingCar> {

    /**
     * @Description: 查询当前用户的所有购物车 默认购物车
     * @Param: userId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Select("SELECT shoppingCar.*,good.name,good.media,good.price from shoppingCar left join good on shoppingCar.goods_id = good.id where user_id = #{userId}")
    List<Trolley> getAll(int userId);
}
