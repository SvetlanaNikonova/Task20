package com.coherentsolutions.training.aqa.java.web.nikonova.shop;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class RealItemTest {

    @Parameters({"weight"})
    @Test
    public void testWeightOfRealItem(double weight) {

        RealItem car = new RealItem();
        car.setWeight(weight);

        Assert.assertEquals(weight, car.getWeight());
    }
}