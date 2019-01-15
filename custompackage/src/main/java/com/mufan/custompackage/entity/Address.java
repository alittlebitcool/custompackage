package com.mufan.custompackage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 15:48 2019/1/14
 * @ Description：收货地址实体类
 * % @author YuXingZh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {
    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private Integer userId;
    private String addressName;
    private Boolean status;
    private String receiver;
    private String telephone;

}
