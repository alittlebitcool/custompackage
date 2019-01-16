package com.mufan.custompackage.web;

import com.mufan.custompackage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private OrderService orderService;

    @RequestMapping("status")
    public Map<String,Integer> getAllStatus(int userId) {
        return orderService.getAllStatus(userId);
    }
}
