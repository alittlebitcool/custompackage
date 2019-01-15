package com.mufan.custompackage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 20:55 2019/1/15
 * @ Description：
 * % @author YuXingZh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trolley {
    private int id;
    private int num;
    private int userId;
    private int goodsId;
    private Boolean checked;
    private String name;
    private String media;
    private Double price;
}
