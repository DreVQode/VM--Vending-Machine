package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class VendingMachineTest extends TestCase {

    private VendingMachine vendingMachine = new VendingMachine();
    private int balance = 300;
    private Map<String, Chip> testMap = new TreeMap<String, Chip>() {{
        put("C4", Chip);}};



    @Test
    public void testAddFeedMoney() {

        Assert.assertEquals(500, vendingMachine.addFeedMoney(5));
    }


//    public void testGetChange() {
//
//
//        Assert.assertEquals(300, vendingMachine.getChange());
//    }
    @Test
    public void testGetProduct() throws InvalidTransactionException {


        Assert.assertEquals("Heavy", vendingMachine.getProduct("C4"));
    }


}