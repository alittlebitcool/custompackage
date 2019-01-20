package com.mufan.custompackage.service;

import com.mufan.custompackage.entity.Address;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 14:07 2019/1/16
 * @ Description：地址的业务层
 * % @author YuXingZh
 */
public interface AddressService {

    /**
     * @Description: 更新默认地址
     * @Param: address, userId
     * @return: void
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Transactional
    void updateDefault(int addressId, int userId);

    /**
     * @Description: 插入地址
     * @Param: address
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Transactional
    void insertAddress(Address address);

    /**
     * @Description: 编辑地址
     * @Param: address
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Transactional
    void editAddress(Address address);


    /**
     * @Description: 移除地址
     * @Param: addressId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Transactional
    void removeAddress(int addressId);

    /**
     * @Description: 查询当前用户的所有地址 默认地址置顶
     * @Param: addressId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    List<Address> getAll(int userId);

    /**
     * @return address
     * @Description: 获取默认地址
     * @Param: userId
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    Address getDefaultAddress(int userId);

//    Address getAddress(int addressId);
}
