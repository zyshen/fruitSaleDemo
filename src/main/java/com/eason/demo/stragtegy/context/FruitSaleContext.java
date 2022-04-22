package com.eason.demo.stragtegy.context;

import com.eason.demo.bo.FruitSaleBo;
import com.eason.demo.factory.FruitSaleStrategyFactory;
import com.eason.demo.stragtegy.FruitSaleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 策略上下文
 * Created by eason on 2022/4/22.
 */
@Component
public class FruitSaleContext {

    @Autowired
    FruitSaleStrategyFactory fruitSaleStrategyFactory;

    FruitSaleStrategy fruitSaleStrategy;

    public void setFruitSaleStrategy(String type) {
        this.fruitSaleStrategy = fruitSaleStrategyFactory.getFruitSaleStrategy(type);
    }

    public double sale(FruitSaleBo saleBo) {
        return fruitSaleStrategy.sale(saleBo);
    }

}
