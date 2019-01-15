package com.mufan.custompackage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:07 2019/1/14
 * @ Description：用户实体类
 * % @author YuXingZh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shoppingCar")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
}
