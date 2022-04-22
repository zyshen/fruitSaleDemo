package com.eason.demo.stragtegy.impl;

import com.eason.demo.common.Constants;
import com.eason.demo.entity.DiscountRule;
import com.eason.demo.entity.Fruit;
import com.eason.demo.stragtegy.FruitSaleStrategy;
import com.eason.demo.bo.FruitSaleBo;
import com.eason.demo.utils.ArithUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 满级优惠策略
 * Created by eason on 2022/4/22.
 */
@Service(Constants.SaleStrategyType.OVEROFF)
@Slf4j
public class FruitSaleStrategyForOverOff implements FruitSaleStrategy {

    @Autowired
    private FruitSaleStrategyForDiscount discountStrategy;

    @Override
    public double sale(FruitSaleBo bo) {
        double totalPrice = discountStrategy.sale(bo);
        DiscountRule discountRule = bo.getDiscountRule();
        if(discountRule != null){
            totalPrice = totalPrice >= discountRule.getOverPrice() ? ArithUtil.sub(totalPrice, discountRule.getOffPrice()) : totalPrice;
        }
        return ArithUtil.round(totalPrice, 2);
    }
}
