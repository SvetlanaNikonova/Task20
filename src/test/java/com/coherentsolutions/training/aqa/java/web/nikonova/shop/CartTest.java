package com.coherentsolutions.training.aqa.java.web.nikonova.shop;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

public class CartTest {

    @Test
    public void testCartName() {
        String expectedResult = "CartTest1";
        assertEquals(getCartName("CartTest1"), expectedResult, "Result is mismatched");
    }

    private String getCartName(String cartName) {
        Cart cart = new Cart(cartName);
        return cart.getCartName();
    }

    @Test
    public void testCartTotalPrice() {
        BigDecimal expectedPrice = new BigDecimal(550.5 * 2 + (550.5 * 0.2) * 2);
        assertEquals(getCartTotalPrice("CartTest1", 550.5), expectedPrice.doubleValue(), "Price is mismatched");
    }

    private double getCartTotalPrice(String cartName, double price) {
        Cart cart = new Cart(cartName);
        RealItem realItem = new RealItem();
        realItem.setPrice(price);
        cart.addRealItem(realItem);
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setPrice(price);
        cart.addVirtualItem(virtualItem);
        return cart.getTotalPrice();
    }

    @Test
    public void checkCartTotalAndName() {

        String cartName = "test-cart";
        double price1 = 43455;
        double price2 = 250;

        Cart cart = new Cart(cartName);

        RealItem car = new RealItem();
        car.setName("Audi");
        car.setPrice(price1);
        car.setWeight(1560);
        cart.addRealItem(car);

        RealItem phone = new RealItem();
        phone.setName("Samsung");
        phone.setPrice(price2);
        phone.setWeight(.200);
        cart.addRealItem(phone);

        double totalAfterAddItem = cart.getTotalPrice();

        SoftAssert sa = new SoftAssert();

        sa.assertEquals(totalAfterAddItem, (price2 + price1) * 1.2);
        sa.assertEquals(cartName, cart.getCartName());
        sa.assertAll();
    }

    @Test(groups = {"includeGroups"})
    public void checkTotalAfterItemRemove() {

        double price1 = 300;
        double price2 = 250;

        Cart cart = new Cart("totals-cart");

        RealItem car = new RealItem();
        car.setName("Audi");
        car.setPrice(price1);
        cart.addRealItem(car);

        RealItem phone = new RealItem();
        phone.setName("Droid");
        phone.setPrice(price2);
        cart.addRealItem(phone);

        cart.deleteRealItem(phone);

        double totalAfterRemoveItem = cart.getTotalPrice();

        Assert.assertEquals((price1 + price2) * 1.2, totalAfterRemoveItem);
    }
}


