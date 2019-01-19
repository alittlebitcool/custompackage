package com.mufan.custompackage.dao;

import com.mufan.custompackage.entity.Order;
import com.mufan.custompackage.entity.OrderDetail;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Date       ：Created in 16:45 2019/1/14
 * @Description：订单类mapper
 * @Author YuXingZh
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
     * @Param: partsId
     * @return: int
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

    /**
     * @Description: 设置订单状态
     * @Param: orderId,status
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Select("UPDATE `order` SET STATUS = ${status} WHERE id = #{orderId};")
    void setStatus(int orderId,int status);

    /**
     * @Description: 取消订单 设置关闭时间
     * @Param: orderId
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Select("update order_detail set close_time = NOW() where order_id = #{orderId} ")
    void setCloseTime(int orderId);

    /**
     * @Description: 完成订单 设置结束时间
     * @Param: orderId
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Select("update order_detail set end_time = NOW() where order_id = " +
            "#{orderId} ")
    void setEndTime(int orderId);

    /**
     * @Description: 完成订单 设置结束时间
     * @Param: orderId,text
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Select("UPDATE `order` SET evaluated = #{text} WHERE id = #{orderId}")
    void orderEvaluate(int orderId, String text);

    /**
     * @Description: 获取全部的订单信息
     * @Param: userId
     * @return: list
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @Select("SELECT a.id, b.media, b.NAME, a.STATUS, a.sum_price, c.num FROM " +
            "`order` a, good b, order_detail c WHERE c.order_id = a.id AND c" +
            ".good_id = b.id AND a.user_id = #{userId};")
    List<OrderDetail> getAll(int userId);

    /**
     * @Description: 完成订单 设置结束时间
     * @Param: orderId
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Select("update order_detail set comment_time = NOW() where order_id = " +
            "#{orderId} ")
    void setEvaluateTime(int orderId);

    /**
     * @Description: 高并发下 获取自己最后加入的订单
     * @Param:
     * @return: int
     * @Author: YuXingZh
     * @Date: 2019/1/19
     */
    @Select("SELECT LAST_INSERT_ID()")
    int getLastInsertId();

    /**
     * @Description: 插入订单详情
     * @Param:
     * @return: int
     * @Author: YuXingZh
     * @Date: 2019/1/19
     */
    @Select("INSERT INTO order_detail (order_id,good_id,num) VALUES" +
            "(#{lastInsertId},#{goodId},#{num})")
    void insertOrderDetail(int lastInsertId, int goodId, int num);

    /**
     * @Description: 插入订单 由于需要`而无法直接使用通用mapper
     * @Param:
     * @return: int
     * @Author: YuXingZh
     * @Date: 2019/1/19
     */
    @Select("INSERT INTO `order` ( user_id,`status`,address_id,message," +
            "sum_price) VALUES (#{userId},1,#{addressId},#{message}," +
            "#{sumPrice})")
    void insertOrder(int userId, int addressId, String message, Double sumPrice);
}
