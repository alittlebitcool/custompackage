package com.mufan.custompackage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 15:50 2019/1/14
 * @ Description：购买订单实体类
 * % @author YuXingZh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    private Integer id;
    private Integer userId;
    private Date date;
    private String goodsJson;
    private String status;
    private String logisticCode;
    private String expressCompany;
    private String message;
}
