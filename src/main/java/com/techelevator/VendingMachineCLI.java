package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String SECOND_MENU_FEED_MONEY = "Feed Money";
	private static final String SECOND_MENU_SELECT_PRODUCT = "Select Product";
	private static final String SECOND_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SECOND_MENU_OPTIONS = { SECOND_MENU_FEED_MONEY, SECOND_MENU_SELECT_PRODUCT, SECOND_MENU_FINISH_TRANSACTION };
	private Scanner keyboard = new Scanner(System.in);

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws FileNotFoundException {
		VendingMachine vendoMatic800 = new VendingMachine();
		vendoMatic800.loadInventory("vendingmachine.csv");


		boolean exitProgram = false;
		boolean start2ndMenu = false;
		while (!exitProgram) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for(Map.Entry<String,Item> entry : vendoMatic800.getInventory().entrySet()) {
					System.out.println(entry.getKey() + " " + entry.getValue().getProductName() + " $" + entry.getValue().getPrice() + " " + entry.getValue().getItemCount() + " in stock");
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				start2ndMenu = true;
				while (start2ndMenu) {
					String choice2 = (String) menu.getChoiceFromOptions(SECOND_MENU_OPTIONS);

					if (choice2.equals(SECOND_MENU_FEED_MONEY)) {
						int feed = getFeedMoney();
						int newBalance = vendoMatic800.addFeedMoney(feed);
						System.out.println("Your new balance is " + newBalance);
					} else if (choice2.equals(SECOND_MENU_SELECT_PRODUCT)) {
						for(Map.Entry<String,Item> entry : vendoMatic800.getInventory().entrySet()) {
							System.out.println(entry.getKey() + " " + entry.getValue().getProductName() + " $" + entry.getValue().getPrice());
						}
						System.out.println("Make your selection ");
							String slotIdentifier = keyboard.nextLine();
						try { Item item = vendoMatic800.getProduct(slotIdentifier);
							System.out.println("You bought " + slotIdentifier + " " + item.getProductName()+ " $" + item.getPrice() + " " + item.getDispenseMessage());
							System.out.println("Your remaining balance is " + vendoMatic800.getMachineBalance(item));
						} catch (InvalidTransactionException e) {
							System.out.println("Something went wrong " + e.getMessage());
						}
					} else if (choice2.equals(SECOND_MENU_FINISH_TRANSACTION)) {
						start2ndMenu = false;
						int change = vendoMatic800.getChange();
//						TODO: display as quarters, dimes, nickels
						System.out.println("Your change is $" + change);
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				exitProgram = true;
			}
		}


	}

	private int getFeedMoney() {
		System.out.println("How much money would you like to deposit? 1, 5 or 10 ");
		String choice = keyboard.nextLine();
		int feedBalance = 0;
		if (choice.equals("1")) {
			feedBalance += 1;
		} else if (choice.equals("5")) {
			feedBalance += 5;
		} else if (choice.equals("10")) {
			feedBalance += 10;
		} else {
			System.out.println("Money input invalid");
		}
		return feedBalance;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
