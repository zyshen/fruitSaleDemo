package com.eason.demo.stragtegy.impl;

import com.eason.demo.bo.FruitSaleBo;
import com.eason.demo.entity.Fruit;
import com.eason.demo.stragtegy.FruitSaleStrategy;
import com.eason.demo.utils.ArithUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 平常策略
 * Created by eason on 2022/4/22.
 */
@Service("normal")
@Slf4j
public class FruitSaleStrategyForNormal implements FruitSaleStrategy {
    @Override
    public double sale(FruitSaleBo bo) {
        List<Fruit> fruitList = bo.getFruitList();
        if (fruitList == null || fruitList.isEmpty()) {
            return 0;
        }
        double totalPrice = 0;
        for (int i = 0; i < fruitList.size(); i++) {
            Fruit fruit = fruitList.get(i);
            if(fruit.getQuality()<=0){
                continue;
            }
            try {
                totalPrice += ArithUtil.mul(fruit.getPrice(), fruit.getQuality());
            } catch (Exception e) {
                log.error("【平常策略计算总价，参数出现异常，参数为：{}】", fruit);
            }
        }
        return ArithUtil.round(totalPrice, 2);
    }
}
