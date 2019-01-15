package com.mufan.custompackage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 15:50 2019/1/14
 * @ Description：购物车实体类
 * % @author YuXingZh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shoppingCar")
public class ShoppingCar {
    @Id
    @Column(name = "id")
    private Integer id;
    private Integer num;
    private Integer userId;
    private String goodsId;
    private Boolean checked;
}
