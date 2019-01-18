package com.mufan.custompackage.web;

import com.mufan.custompackage.entity.OrderDetail;
import com.mufan.custompackage.service.OrderService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 19:23 2019/1/16
 * @ Description：订单控制层
 * % @author YuXingZh
 */
@RestController
@RequestMapping("order")
public class OrderController {

    private static Logger logger = Logger.getLogger(ShoppingCarController.class);

    @Autowired
    private OrderService orderService;

    /**
     * @Description: 显示未结束订单的状态
     * @Param: userId
     * @return:a Map
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @RequestMapping("status")
    public Map<String, Integer> getAllStatus(int userId) {
        logger.info("显示未结束订单的状态");
        Map<String, Integer> map = orderService.getAllStatus(userId);
        logger.info("显示成功");
        return map;
    }

    /**
     * @Description: 显示立即购买页面
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @RequestMapping("show")
    public Map<String, Object> purchaseImmediate(@RequestParam("partsId") List<Integer> partsId,
                                                 @RequestParam("num") int num, @RequestParam("userId") int userId) {
        logger.info("显示立即购买页面");
        Map<String, Object> map = orderService.purchaseImmediate(partsId, num, userId);
        logger.info("显示成功");
        return map;
    }

//    /**
//     * @Description: 订单状态
//     * @Param:
//     * @return:
//     * @Author: YuXingZh
//     * @Date: 2019/1/17
//     */
//
//    @RequestMapping("getAll")

    /**
     * @Description: 取消订单
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @RequestMapping("cancel")
    public void cancelOrder(@RequestParam("orderId") int orderId) {
        logger.info("取消订单编号为" + orderId + "的订单");
        orderService.cancelOrder(orderId);
        logger.info("取消订单编号为" + orderId + "的订单");
    }

    /**
     * @Description: 确认收货
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @RequestMapping("confirm")
    public void harvestConfirm(@RequestParam("orderId") int orderId) {
        logger.info("确认收货订单编号为" + orderId + "的订单");
        orderService.harvestConfirm(orderId);
        logger.info("取消订单成功");
    }

    /**
     * @Description: 评价订单
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @RequestMapping(value = "evaluate", produces = "application/json")
    public void orderEvaluate(@RequestParam("orderId") int orderId,
                              @RequestParam("text") String text) {
        logger.info("评价订单订单编号为" + orderId + "的订单");
        orderService.orderEvaluate(orderId,text);
        logger.info("评价订单成功");
    }

    /**
     * @Description: 获取全部订单详情
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @RequestMapping("all")
    public List<OrderDetail> getAll(@RequestParam("userId") int userId) {
        logger.info("返回用户" + userId + "的全部订单");
        List<OrderDetail> list = orderService.getAll(userId);
        logger.info("取消订单成功");
        return list;
    }
}
