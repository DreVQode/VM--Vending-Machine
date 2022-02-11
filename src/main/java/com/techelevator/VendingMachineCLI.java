package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;

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

	public void run() throws FileNotFoundException {
		VendingMachine vendoMatic800 = new VendingMachine();


		boolean exitProgram = false;
		boolean start2ndMenu = false;
		while (!exitProgram) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(vendoMatic800.getInventory());
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				start2ndMenu = true;
				while (start2ndMenu) {
					String choice2 = (String) menu.getChoiceFromOptions(SECOND_MENU_OPTIONS);

					if (choice2.equals(SECOND_MENU_FEED_MONEY)) {
						Money money = new Money();
						int customerBalance = money.feedMoney();
					} else if (choice2.equals(SECOND_MENU_SELECT_PRODUCT)) {
						// select product
					} else if (choice2.equals(SECOND_MENU_FINISH_TRANSACTION)) {
						start2ndMenu = false;
					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				exitProgram = true;
			}
		}


	}



	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
