package com.eason.demo.factory;

import com.eason.demo.stragtegy.FruitSaleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by eason on 2022/4/22.
 */
@Service
public class FruitSaleStrategyFactory {

    // spring容器启动会加载所有到该map中
    @Autowired
    Map<String, FruitSaleStrategy> bases = new ConcurrentHashMap<>();

    public FruitSaleStrategy getFruitSaleStrategy(String type) {
        FruitSaleStrategy FruitSaleStrategy = bases.get(type);
        return FruitSaleStrategy;
    }

}
