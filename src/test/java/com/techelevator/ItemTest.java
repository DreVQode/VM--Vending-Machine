package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ItemTest extends TestCase {

    private Item item;
    private int itemCount;

    public void setUp() {item = new Item("lays", 250, "hi"); this.itemCount = 5; }

    @Test
    public void testGetProductName() {

        Assert.assertEquals("lays", item.getProductName());

    }

    public void testGetPrice() {
        Assert.assertEquals(250, item.getPrice());

    }

    public void testGetDispenseMessage() {
        Assert.assertEquals("hi", item.getDispenseMessage());

    }

    public void testGetItemCount() {
        Assert.assertEquals(5, item.getItemCount());


    }

//    public void testReduceItemCount() {
//        Assert.assertEquals(4, item.reduceItemCount());

//    }
}