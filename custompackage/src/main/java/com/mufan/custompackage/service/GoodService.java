package com.mufan.custompackage.service;

import com.mufan.custompackage.dao.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：商品类service
 * % @author YuXingZh
 */
@Service
public class GoodService {

    @Autowired
    private GoodMapper goodMapper;
}
