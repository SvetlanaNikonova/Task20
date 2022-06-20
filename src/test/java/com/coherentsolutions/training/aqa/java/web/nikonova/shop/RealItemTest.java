package com.coherentsolutions.training.aqa.java.web.nikonova.shop;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class RealItemTest {

    @Parameters({"weight"})
    @Test
    public void testWeightOfRealItem(double weight) {

        RealItem car = new RealItem();
        car.setWeight(weight);

        Assert.assertEquals(weight, car.getWeight());
        /*
        BigDecimal expectedResult = new BigDecimal(200);
        RealItem realItem = new RealItem();

        realItem.setWeight(expectedResult.doubleValue());
        assertEquals(expectedResult.doubleValue(), realItem.getWeight(), "Weight is mismatched");
    }*/
    }
}