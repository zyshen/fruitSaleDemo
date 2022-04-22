package com.eason.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by eason on 2022/4/22.
 */
@Data
@AllArgsConstructor
public class DiscountRule {

    /*满足条件价钱*/
    private double overPrice;
    /*减少价钱*/
    private double offPrice;
}
