package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.PartMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PartServiceImplTest {

    @Autowired
    private PartMapper partMapper;

    @Test
    public void getFirstPart() {
        List<Integer>list = partMapper.getFirstPart();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}