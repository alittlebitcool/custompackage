package com.mufan.custompackage.dao;

import com.mufan.custompackage.entity.Order;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：订单类mapper
 * % @author YuXingZh
 */
public interface OrderMapper extends Mapper<Order> {

    /**
     * @Description: 查询状态为待付款的订单
     * @Param: userId
     * @return: count
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT COUNT(*) FROM `order` WHERE STATUS = 1 AND user_id = #{userId}")
    int pendingPayment(int userId);

    /**
     * @Description: 查询状态为待发货的订单
     * @Param: userId
     * @return: count
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT COUNT(*) FROM `order` WHERE STATUS = 2 AND user_id = #{userId}")
    int pendingDelivery(int userId);

    /**
     * @Description: 查询状态为待收货的订单
     * @Param: userId
     * @return: count
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT COUNT(*) FROM `order` WHERE STATUS = 3 AND user_id = #{userId}")
    int pendingGain(int userId);

    /**
     * @Description: 查询状态为待评价的订单
     * @Param: userId
     * @return: count
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT COUNT(*) FROM `order` WHERE STATUS = 4 AND user_id = #{userId}")
    int pendingEvaluated(int userId);

    /**
     * @Description: 得到当前部件组成的good
     * @Param: userId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Select("SELECT id FROM good where part_id= #{partsId}")
    int getGoodId(String partsId);

//    /**
//     * @Description: 得到当前部件组成的good
//     * @Param: userId
//     * @return: null
//     * @Author: YuXingZh
//     * @Date: 2019/1/14
//     */
//    @Select("SELECT id FROM good where part_id= #{partsId}")
//    int insertOrder(String partsId);
}
