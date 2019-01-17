package com.mufan.custompackage.dao;

import com.mufan.custompackage.entity.Address;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：地址类mapper
 * % @author YuXingZh
 */
public interface AddressMapper extends Mapper<Address> {

    /**
     * @Description: 查询当前用户的所有地址 默认地址置顶
     * @Param: addressId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Select("SELECT id,user_id,address_name,status,receiver,telephone FROM address WHERE user_id = #{userId} order by status ")
    List<Address> getAll(int userId);

    /**
     * @Description: 获取默认地址
     * @Param: userId
     * @return address
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT id,user_id,address_name,status,receiver,telephone,freight FROM address WHERE user_id = #{userId} AND status = 1")
    Address getDefaultAddress(int userId);
}
