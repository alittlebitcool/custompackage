package com.mufan.custompackage.web;

import com.mufan.custompackage.entity.Address;
import com.mufan.custompackage.service.AddressService;
import com.mufan.custompackage.service.impl.AddressServiceImpl;
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
 * @ Description：地址接口
 * % @author YuXingZh
 */
@RestController
@RequestMapping("address")
public class AddressController {

    private static Logger logger = Logger.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    /**
     * @Description: 更改默认地址
     * @Param: addressId, userId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("update")
    public void updateDefault(@RequestParam("addressId") int addressId,@RequestParam("userId") int userId) {
        logger.info("更改 " + addressId + " 为默认地址");
        addressService.updateDefault(addressId, userId);
        logger.info("更改成功");
    }

    /**
     * @Description: 插入地址
     * @Param: address
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("insert")
    public void insertAddress(@RequestBody Address address) {
        logger.info("插入" + address);
        addressService.insertAddress(address);
        logger.info("插入成功");
    }

    /**
     * @Description: 编辑地址
     * @Param: address
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("edit")
    public void editAddress(@RequestBody Address address) {
        logger.info("更改" + address);
        addressService.editAddress(address);
        logger.info("更改成功");
    }

    /**
     * @Description: 删除地址
     * @Param: addressId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("delete")
    public void removeAddress(@RequestParam("addressId") int addressId) {
        logger.info("删除id为 " + addressId + "的地址");
        addressService.removeAddress(addressId);
        logger.info("更改成功");
    }

    /**
     * @Description: 查询用户所有地址 默认地址置顶
     * @Param: addressId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("addresses")
    public List<Address> getAll(@RequestParam("userId") int userId) {
        logger.info("查询用户id为 " + userId + "的地址");
        List<Address> list = addressService.getAll(userId);
        logger.info("查询成功");
        return list;
    }

    /**
     * @Description: 获取默认地址
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/17
     */
    @RequestMapping("default")
    public Address defaultAddress(@RequestParam("userId") int userId) {
        logger.info("查询用户id为 " + userId + "的地址");
        Address address = addressService.getDefaultAddress(userId);
        logger.info("查询成功");
        return address;
    }

//    /**
//     * @Description: 选择地址
//     * @Param:
//     * @return:
//     * @Author: YuXingZh
//     * @Date: 2019/1/17
//     */
//    @RequestMapping("select")
//    public Address getAddress(@RequestParam("addressId") int addressId) {
//        logger.info("查询用户id为 " + addressId + "的地址");
//        Address address = addressService.getAddress(addressId);
//        logger.info("查询成功");
//        return address;

//    }

}
