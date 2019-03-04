package com.certiorem.main;

import com.certiorem.carRenting.SelectOnMenu;

public class Main {

	public static void main(String[] args) throws Exception {
		
		SelectOnMenu menu = new SelectOnMenu();
		
		while(true) {
			menu.showMessage();
			menu.selectedMenuSwitcher();
		}
		

	}

}
