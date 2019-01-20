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
    @Select("SELECT id,user_id,address_name,status,receiver,telephone,freight FROM " +
            "address WHERE user_id = #{userId} order by status DESC ")
    List<Address> getAll(int userId);

    /**
     * @return address
     * @Description: 获取默认地址
     * @Param: userId
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT id,user_id,address_name,status,receiver,telephone,freight FROM address WHERE user_id = #{userId} AND status = 1")
    Address getDefaultAddress(int userId);

    /**
     * @return address
     * @Description: 获取默认地址
     * @Param: userId
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("update address set status = 1 where id = #{addressId}")
    void updateAddress(int addressId);

    /**
     * @return address
     * @Description: 获取默认地址
     * @Param: userId
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT id FROM address WHERE user_id = #{userId} LIMIT 1")
    int originalAddress(int userId);

    /**
     * @return address
     * @Description: 判断是否有默认地址
     * @Param: userId
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT COUNT(*) FROM address WHERE user_id = #{userId} and status = 1")
    int hasDefault(int userId);

    /**
     * @return address
     * @Description: 判断是否有默认地址
     * @Param: userId
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT COUNT(*) FROM address WHERE user_id = #{userId}")
    int hasAddress(int userId);
}
