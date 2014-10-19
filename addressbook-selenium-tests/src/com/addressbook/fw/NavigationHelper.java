package com.addressbook.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends BaseHelper {
	
	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openMainPage() {	    
	    //click(By.linkText("home"));
		driver.get(manager.baseUrl + "/addressbookv4.1.4");
	}

	public void goToGroupsPage() {
		click(By.linkText("groups"));
	}

	public void goToContactCreationPage() {
		click(By.linkText("add new"));
	}

}
