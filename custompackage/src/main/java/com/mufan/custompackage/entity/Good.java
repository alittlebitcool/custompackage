package com.mufan.custompackage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 15:49 2019/1/14
 * @ Description：商品样式实体类
 * % @author YuXingZh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "good")
public class Good {
    @Id
    @Column(name = "id")
    private String id;
    private String media;
    private String name;
    private String partId;
    private Integer sort;
    private Double price;
    private Integer first;
}
