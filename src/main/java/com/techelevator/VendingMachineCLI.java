package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String SECOND_MENU_FEED_MONEY = "Feed Money";
	private static final String SECOND_MENU_SELECT_PRODUCT = "Select Product";
	private static final String SECOND_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SECOND_MENU_OPTIONS = { SECOND_MENU_FEED_MONEY, SECOND_MENU_SELECT_PRODUCT, SECOND_MENU_FINISH_TRANSACTION };


	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
//		VendingMachine vendingMachine = new VendingMachine();
//		vendingMachine.getInventory();


		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}
	while (true) {
		String choice = (String) menu.getChoiceFromOptions(SECOND_MENU_OPTIONS);

		if (choice.equals(SECOND_MENU_FEED_MONEY)) {
			// display vending machine items
		} else if (choice.equals(SECOND_MENU_SELECT_PRODUCT)) {
			// do purchase
		}
	}



	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
