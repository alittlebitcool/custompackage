package com.mufan.custompackage.web;

import com.mufan.custompackage.service.OrderService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("status")
    public Map<String,Integer> getAllStatus(int userId) {
        return orderService.getAllStatus(userId);
    }

    /**
     * @Description: 立即购买加入订单
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @RequestMapping("insert")
    public void insertShoppingCar(@RequestBody List<Integer> partsId,
                                  @RequestParam("num") int num, @RequestParam("userId") int userId) {
        logger.info("插入中");
        orderService.insertShoppingCar(partsId, num, userId);
        logger.info("插入成功");
    }

    /**
     * @Description: 订单状态
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
}
