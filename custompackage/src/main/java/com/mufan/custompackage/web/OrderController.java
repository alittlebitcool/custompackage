package com.mufan.custompackage.web;

import com.alibaba.fastjson.JSONArray;
import com.mufan.custompackage.service.OrderService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping("status")
    public Map<String, Integer> getAllStatus(int userId) {
        return orderService.getAllStatus(userId);
    }

    /**
     * @Description: 显示立即购买页面
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @RequestMapping("showImmediate")
    public Map<String, Object> purchaseImmediate(@RequestParam("partsId") List<Integer> partsId,
                                                 @RequestParam("num") int num, @RequestParam("userId") int userId) {
        logger.info("显示立即购买页面");
        return orderService.purchaseImmediate(partsId, num, userId);
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
}
