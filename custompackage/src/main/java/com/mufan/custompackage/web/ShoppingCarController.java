package com.mufan.custompackage.web;

import com.mufan.custompackage.entity.ShoppingCar;
import com.mufan.custompackage.service.ShoppingCarService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 19:49 2019/1/14
 * @ Description：购物车接口
 * % @author YuXingZh
 */
@RestController
@RequestMapping("shoppingCar")
public class ShoppingCarController {

    private static Logger logger = Logger.getLogger(ShoppingCarController.class);

    @Autowired
    private ShoppingCarService shoppingCarService;

    /**
     * @Description: 插入购物车
     * @Param: shoppingCar
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("insert")
    public void insertShoppingCar(@RequestBody ShoppingCar shoppingCar) {
        shoppingCarService.insertShoppingCar(shoppingCar);
    }

    /**
     * @Description: 删除购物车
     * @Param: shoppingCarId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("remove")
    public void removeShoppingCar(@RequestParam("shoppingCarId") int shoppingCarId) {
        shoppingCarService.removeShoppingCar(shoppingCarId);
    }

    /**
     * @Description: 编辑购物车
     * @Param: shoppingCar
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("edit")
    public void editShoppingCar(@RequestParam("shoppingCarId")int shoppingCarId,@RequestParam("num") int num) {
        shoppingCarService.editShoppingCar(shoppingCarId, num);
    }

    /**
     * @Description: 查询用户所有购物车 默认购物车
     * @Param: shoppingCarId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("shoppingCars")
    public List<ShoppingCar> getAll(@RequestParam("userId") int userId) {
        return shoppingCarService.getAll(userId);
    }
}
