package com.eason.demo.bo;

import com.eason.demo.entity.DiscountRule;
import com.eason.demo.entity.Fruit;
import lombok.Data;

import java.util.List;

/**
 * Created by eason on 2022/4/22.
 */
@Data
public class FruitSaleBo {

    /*购买水果*/
    private List<Fruit> fruitList;

    /*优惠规则*/
    private DiscountRule discountRule;
}
