package com.techelevator;

public class Item {

    private String productName;
    private int price;
    private String dispenseMessage;

    public Item(String productName, int price, String dispenseMessage) {
        this.productName = productName;
        this.price = price;
        this.dispenseMessage = dispenseMessage;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getDispenseMessage() {
        return dispenseMessage;
    }
}
