package com.mufan.custompackage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 9:37 2019/1/16
 * @ Description：部件实体类
 * % @author YuXingZh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "part")
public class Part {
    @Id
    private Integer id;
    private String partName;
    private Integer sortId;
    private String imageUrl;
    private Double partPrice;
    private Boolean checked;
}
