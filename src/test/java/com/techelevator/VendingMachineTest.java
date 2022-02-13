package com.techelevator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest extends TestCase {

    private int balance;

//    @Before
//    public final void setUp() {VendingMachine vendingMachine = new VendingMachine(); this.balance = 300;}

    @Test
    public void testGetBalance() {
        VendingMachine vendingMachine = new VendingMachine();

        int result = vendingMachine.getBalance();
        Assert.assertEquals(300, result);
    }

    public void testGetInventory() {

    }

    public void testLoadInventory() {
    }

    public void testAddFeedMoney() {
    }

    public void testGetMachineBalance() {
    }

    public void testGetChange() {
    }

    public void testGetProduct() {
    }

    public void testCoins() {
    }
}