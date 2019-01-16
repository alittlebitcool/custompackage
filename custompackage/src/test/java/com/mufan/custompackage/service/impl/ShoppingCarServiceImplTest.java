package com.mufan.custompackage.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCarServiceImplTest {

    @Autowired
    ShoppingCarServiceImpl shoppingCarService;

    @Test
    public void insertShoppingCar() {
        Integer[] a = new Integer[]{101,201,301};
        List<Integer> list = Arrays.asList(a);
        System.out.println(list);
        shoppingCarService.insertShoppingCar(list,99,1);
    }
}