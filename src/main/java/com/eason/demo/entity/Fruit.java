package com.eason.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 水果类
 * Created by eason on 2022/4/22.
 */
@Data
@AllArgsConstructor
public class Fruit {

    /*水果名称*/
    private String name;
    /*单价*/
    private double price;
    /*质量*/
    private int quality;
    /*折扣*/
    private double discount;

    public Fruit(String name,double price,int quality){
        this.name = name;
        this.price = price;
        this.quality = quality;
    }

}
