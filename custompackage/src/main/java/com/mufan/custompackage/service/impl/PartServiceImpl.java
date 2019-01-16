package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.PartMapper;
import com.mufan.custompackage.entity.Good;
import com.mufan.custompackage.service.PartService;
import com.mufan.custompackage.util.EntityConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * @Description: 查询所有首推部件
     * @Param:
     * @return:a
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
     * @return:a
     * @Author: YuXingZh
     * @Date: 2019/1/16
     */
    @Override
    public Good defaultGood() {
        String goodId = EntityConversion.getGoodId(getFirstPart());

    }
}
