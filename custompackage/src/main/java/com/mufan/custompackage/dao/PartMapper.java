package com.mufan.custompackage.dao;

import com.mufan.custompackage.entity.Part;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 9:40 2019/1/16
 * @ Description：
 * % @author YuXingZh
 */
public interface PartMapper extends Mapper<Part> {

    /**
     * @Description: 查询所有首推部件 暂时定为三种 增加组件则查询sort分类
     * @Param:
     * @return:a
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT id FROM part GROUP BY sort_id limit 3")
    List<Integer> getFirstPart();

    /**
     * @Description: 得到部件的分类
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Select("SELECT count(distinct(sort_id)) FROM part ")
    public int getSortNum();
}
