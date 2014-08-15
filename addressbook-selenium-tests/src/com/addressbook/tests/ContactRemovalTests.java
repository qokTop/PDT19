package com.addressbook.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void testDeleteContactViaEditPage() {
		int tdNumOfContact = 1;
		
		appManager.getContactHelper().openEditPageOfContact(tdNumOfContact);
		appManager.getContactHelper().deleteContact();
		appManager.getContactHelper().returnToHomePage();;
	}	

}
