package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.GoodMapper;
import com.mufan.custompackage.dao.PartMapper;
import com.mufan.custompackage.entity.Good;
import com.mufan.custompackage.entity.Part;
import com.mufan.custompackage.service.PartService;
import com.mufan.custompackage.util.EntityConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 9:40 2019/1/16
 * @ Description：
 * % @author YuXingZh
 */
@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private PartMapper partMapper;

    @Autowired
    private GoodMapper goodMapper;

    /**
     * @Description: 查询所有首推部件
     * @Param:
     * @return: list
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Override
    public List<Integer> getFirstPart() {
        return partMapper.getFirstPart();
    }

    /**
     * @Description: 得到默认的背包
     * @Param:
     * @return: Good
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Override
    public Good defaultGood() {
        String goodId = EntityConversion.getGoodId(getFirstPart());
        Good good = new Good();
        good.setPartId(goodId);
        return goodMapper.selectOne(good);
    }

    /**
     * @Description: 选择部件
     * @return: map
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Override
    public Map<String, Object> partSelect() {
        Map<String, Object> map = new HashMap<>();
        List<Map<String,Object>> list = getParts();
        map.put("bag",defaultGood());
        map.put("partsList",list);
        return map;
    }

    /**
     * @Description: 得到当前分类的部件信息
     * @Param: partId
     * @return: map
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    public Map<String, Object> getPart(int partId) {
        Map<String, Object> map = new HashMap<>();
        Part part = new Part();
        part.setSortId(partId);
        map.put("sortId", partId);
        map.put("sortName", "部件" + partId);
        map.put("parts",partMapper.select(part));
        return map;
    }

    /**
     * @Description: 得到不同分类所有的部件信息
     * @return:list
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    public List<Map<String,Object>> getParts() {
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 1; i <= getSortNum(); i++) {
            list.add(getPart(i));
        }
        return list;
    }

    /**
     * @Description: 得到部件的分类
     * @return: int
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    public int getSortNum() {
        return partMapper.getSortNum();
    }
}
