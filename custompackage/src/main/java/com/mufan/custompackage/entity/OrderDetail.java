package com.mufan.custompackage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 20:05 2019/1/16
 * @ Description：订单细节
 * % @author YuXingZh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    private Integer id;
    private String media;
    private String name;
    private Integer status;
    private Double sumPrice;
    private Integer num;

}
