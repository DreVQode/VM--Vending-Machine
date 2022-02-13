package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest extends TestCase {

    private VendingMachine vendingMachine;
    private int balance;


    @Before
    public final void setUp() {VendingMachine vendingMachine = new VendingMachine();}

    @Test
    public void testAddFeedMoney() {

        Assert.assertEquals(500, vendingMachine.addFeedMoney(5));
    }


    public void testGetChange() {
    }

    public void testGetProduct() {
    }


}