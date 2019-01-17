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
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    private Integer id;
    private Integer orderId;
    private Integer goodId;
    private Integer num;
    private Date createTime;
    private Date paymentTime;
    private Date consignTime;
    private Date endTime;
    private Date closeTime;
    private Date commentTime;

}
