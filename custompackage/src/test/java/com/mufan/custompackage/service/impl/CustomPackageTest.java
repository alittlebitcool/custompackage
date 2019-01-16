package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.PartMapper;
import com.mufan.custompackage.service.AddressService;
import com.mufan.custompackage.service.PartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomPackageTest {

    @Autowired
    private PartMapper partMapper;

    @Autowired
    private PartServiceImpl partServiceImpl;

    @Autowired
    ShoppingCarServiceImpl shoppingCarServiceImpl;

    @Autowired
    AddressServiceImpl addressServiceImpl;

    @Test
    public void getFirstPart() {
        List<Integer>list = partMapper.getFirstPart();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    @Test
    public void partSelect() {
//        System.out.println(partServiceImpl.partSelect());
    }

    @Test
    public void getFirstPart1() {
        System.out.println(partServiceImpl.getFirstPart());
    }

    @Test
    public void defaultGood() {
        System.out.println(partServiceImpl.defaultGood());
    }

    @Test
    public void partSelect1() {
//        System.out.println(partServiceImpl.partSelect());
    }

    @Test
    public void getParts() {
        System.out.println(partServiceImpl.getParts());
    }

    @Test
    public void getSortNum() {
        System.out.println(partServiceImpl.getSortNum());
    }

    @Test
    public void insertShoppingCar() {
        Integer[] a = new Integer[]{101,201,301};
        List<Integer> list = Arrays.asList(a);
        System.out.println(list);
        shoppingCarServiceImpl.insertShoppingCar(list,99,1);
    }

    @Test
    public void getDefaultAddress(){
        System.out.println(addressServiceImpl.getDefaultAddress(1));
    }




}