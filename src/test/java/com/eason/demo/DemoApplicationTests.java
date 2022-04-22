package com.eason.demo;

import com.eason.demo.bo.FruitSaleBo;
import com.eason.demo.entity.DiscountRule;
import com.eason.demo.entity.Fruit;
import com.eason.demo.stragtegy.context.FruitSaleContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    FruitSaleContext fruitSaleContext;

    /**
     * 购买5斤苹果，3斤草莓
     */
    @Test
    public void countTotalPriceByNormal1() {
        fruitSaleContext.setFruitSaleStrategy("normal");
        FruitSaleBo bo = new FruitSaleBo();
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("苹果", 8, 5));
        fruitList.add(new Fruit("草莓", 13, 3));
        bo.setFruitList(fruitList);
        System.out.println("购买的水果总价为：" + fruitSaleContext.sale(bo));
    }

    /**
     * 购买5斤苹果，3斤草莓,3斤芒果
     */
    @Test
    public void countTotalPriceByNormal2() {
        fruitSaleContext.setFruitSaleStrategy("normal");
        FruitSaleBo bo = new FruitSaleBo();
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("苹果", 8,5));
        fruitList.add(new Fruit("草莓", 13, 3));
        fruitList.add(new Fruit("芒果", 20, 3));
        bo.setFruitList(fruitList);
        System.out.println("购买的水果总价为：" + fruitSaleContext.sale(bo));
    }

    /**
     * 购买5斤苹果，3斤草莓,3斤芒果 草莓8折
     */
    @Test
    public void countTotalPriceByDiscount() {
        fruitSaleContext.setFruitSaleStrategy("discount");
        FruitSaleBo bo = new FruitSaleBo();
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("苹果", 8, 5));
        fruitList.add(new Fruit("草莓", 13, 3, 0.8));
        fruitList.add(new Fruit("芒果", 20, 3));
        bo.setFruitList(fruitList);
        System.out.println("购买的水果总价为：" + fruitSaleContext.sale(bo));
    }

    /**
     * 购买5斤苹果，3斤草莓,3斤芒果 草莓8折，满100减10块
     */
    @Test
    public void countTotalPriceByOverOff() {
        fruitSaleContext.setFruitSaleStrategy("overOff");
        FruitSaleBo bo = new FruitSaleBo();
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("苹果", 8, 5));
        fruitList.add(new Fruit("草莓", 13, 3, 0.8));
        fruitList.add(new Fruit("芒果", 20, 3));
        bo.setFruitList(fruitList);
        bo.setDiscountRule(new DiscountRule(100, 10));
        System.out.println("购买的水果总价为：" + fruitSaleContext.sale(bo));
    }
}
