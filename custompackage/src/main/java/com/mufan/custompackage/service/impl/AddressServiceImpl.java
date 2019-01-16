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
     * @Description: 更新默认地址
     * @Param: address, userId
     * @return: void
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void updateDefault(String addressId, int userId) {
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
     * @Description: 插入地址
     * @Param: address
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void insertAddress(Address address) {
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
     * @Description: 查询当前用户的所有地址 默认地址置顶
     * @Param: addressId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public List<Address> getAll(int userId) {
        return addressMapper.getAll(userId);
    }
}
