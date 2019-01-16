package com.mufan.custompackage.web;

import com.mufan.custompackage.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 14:59 2019/1/16
 * @ Description：部件的控制层
 * % @author YuXingZh
 */
@RestController
@RequestMapping("part")
public class PartController {

    @Autowired
    private PartService partService;

    @RequestMapping("select")
    public Map<String,Object> partSelect() {
        return partService.partSelect();
    }
}
