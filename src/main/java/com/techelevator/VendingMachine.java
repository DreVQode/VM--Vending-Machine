package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
    private Map<String,Item> inventory = new TreeMap<>();

//    public VendingMachine(Map inventory) {
//        this.inventory = inventory;
//    }
//
//    public VendingMachine() {
//
//    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public void loadInventory(String fileName) throws FileNotFoundException {
        File inputFile = new File("vendingmachine.csv");
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String lineFromFile = scanner.nextLine();
                String [] splits = lineFromFile.split("\\|");
                String slotIdentifier = splits[0];
                String itemName = splits[1];
                int price = (int)(Double.parseDouble(splits[2]) * 100);
                String category = splits[3];
                Item item = null;
                if (category.equalsIgnoreCase("chip")) {
                    item = new Chip(itemName, price);
                } else if(category.equalsIgnoreCase("candy")) {
                    item = new Candy(itemName, price);
                }  else if(category.equalsIgnoreCase("drink")) {
                    item = new Drink(itemName, price);
                }else {
                    item = new Gum(itemName, price);
                }
                inventory.put(slotIdentifier, item);
            }
        }

    }
}
