package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.AddressMapper;
import com.mufan.custompackage.entity.Address;
import com.mufan.custompackage.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：地址类service
 * % @author YuXingZh
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * @Description: 更新默认地址 此时必须要有默认地址 没有需要去add
     * @Param: address, userId
     * @return: void
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void updateDefault(int addressId, int userId) {
        // 如果没有默认地址的话 避免空指针跳转addDefault();
        if(!hasDefault(userId)) {
            addDefault(addressId);
            return ;
        }

        Address ad = new Address();
        ad.setStatus(true);
        ad.setUserId(userId);

        // 默认地址的替换
        Address defaulted = addressMapper.selectOne(ad);
        Address address = addressMapper.selectByPrimaryKey(addressId);
        defaulted.setStatus(false);
        address.setStatus(true);

        // 更新到数据库
        addressMapper.updateByPrimaryKey(defaulted);
        addressMapper.updateByPrimaryKey(address);
    }

    /**
     * @Description: 更新地址默认地址
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    public void addDefault(int addressId) {
        Address address = new Address();
        address.setId(addressId);
        address.setStatus(true);
        addressMapper.updateByPrimaryKeySelective(address);
    }

    /**
     * @Description: 插入地址
     * @Param: address
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void insertAddress(Address address) {
        address.setFreight(10.00);
        addressMapper.insert(address);
    }

    /**
     * @Description: 编辑地址
     * @Param: address
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void editAddress(Address address) {
        Address original = addressMapper.selectByPrimaryKey(address.getId());
        // 判断是否需要修改
        if (!original.equals(address)) {
            addressMapper.updateByPrimaryKeySelective(address);
        }
    }

    /**
     * @Description: 移除地址
     * @Param: addressId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void removeAddress(int addressId) {
        addressMapper.deleteByPrimaryKey(addressId);
    }

    /**
     * @Description: 当默认地址为空的时候 需要加入一条地址为默认地址 先查出来
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    public int originalAddress(int userId) {
        return addressMapper.originalAddress(userId);
    }

    /**
     * @Description: 判断是否有地址
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    public Boolean hasDefault(int userId) {
        return addressMapper.hasDefault(userId) == 1;
    }

    /**
     * @Description: 判断是否有默认地址
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/20
     */
    public Boolean hasAddress(int userId) {
        return addressMapper.hasAddress(userId) >= 1;
    }

    /**
     * @Description: 查询当前用户的所有地址 默认地址置顶
     * @Param: addressId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public List<Address> getAll(int userId) {
        if(hasAddress(userId) && !hasDefault(userId)) {
            addDefault(originalAddress(userId));
        }
        return addressMapper.getAll(userId);
    }

    /**
     * @return address
     * @Description: 获取默认地址
     * @Param: userId
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Override
    public Address getDefaultAddress(int userId) {
        return addressMapper.getDefaultAddress(userId);
    }

//    /**
//     * @Description: 选择地址
//     * @Param: userId
//     * @return address
//     * @Author: YuXingZh
//     * @Date: 2019/1/16
//     */
//    @Override
//    public Address getAddress(int addressId) {
//        return addressMapper.selectByPrimaryKey(addressId);
//    }
}
