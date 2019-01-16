package com.mufan.custompackage.service;

import com.mufan.custompackage.entity.Good;

import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 14:08 2019/1/16
 * @ Description：部件的业务层
 * % @author YuXingZh
 */
public interface PartService {

    /**
     * @Description: 查询所有首推部件
     * @Param:
     * @return:a
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    public List<Integer> getFirstPart();

    /**
     * @Description: 得到默认的背包
     * @Param:
     * @return:a
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    public Good defaultGood();

    /**
     * @Description: 选择部件
     * @Param: a
     * @return: a
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    public Map<String, Object> partSelect();


}