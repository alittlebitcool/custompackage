package com.mufan.custompackage.util;

import java.util.List;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 9:49 2019/1/16
 * @ Description：Part 和 Good 转化工具类
 * % @author YuXingZh
 */
public class EntityConversion {

    /**
     * @Description: 将partId 转化为 GoodId
     * @Param: list
     * @return: result
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    public static String getGoodId(List<Integer> list) {
        StringBuilder result = new StringBuilder();
        for (int temp : list) {
            result.append(temp);
        }
        return result.toString();
    }
}
