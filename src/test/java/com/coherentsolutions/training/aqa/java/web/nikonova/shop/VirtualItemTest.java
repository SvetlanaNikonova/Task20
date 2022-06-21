package com.coherentsolutions.training.aqa.java.web.nikonova.shop;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class VirtualItemTest {

    @Test
    public void testSizeOfVirtualItem() {
        BigDecimal expectedResult = new BigDecimal(25.5);
        VirtualItem virtualItem = new VirtualItem();

        virtualItem.setSizeOnDisk(expectedResult.doubleValue());
        assertEquals(virtualItem.getSizeOnDisk(), expectedResult.doubleValue(), "Size is mismatched");
    }
}
