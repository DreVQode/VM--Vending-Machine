package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
    private Map<String,Item> inventory = new TreeMap<>();

    public void loadInventory(String fileName) throws FileNotFoundException {
        File inputFile = new File(fileName);
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String lineFromFile = scanner.nextLine();
                String [] splits = lineFromFile.split("\\|");
                String slotIdentifier = splits[0];
                String itemName = splits[1];
                int price = (int)(Double.parseDouble(splits[2]) * 100);
                String catogory = splits[3];
                Item item = null;
                if (catogory.equalsIgnoreCase("chip")) {
                    item = new Chip(itemName, price);
//                    need to add other item subclasses and count
                }
                inventory.put(slotIdentifier, item);
            }
        }
    }
}
