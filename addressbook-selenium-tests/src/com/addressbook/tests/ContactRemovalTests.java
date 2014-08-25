package com.addressbook.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void testDeleteContactViaEditPage() {
		int tdNumOfContact = 1;
		
		// save old state
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		// actions
		appManager.getContactHelper().openEditPageOfContact(tdNumOfContact);
		appManager.getContactHelper().deleteContact();
		appManager.getContactHelper().returnToHomePage();
		
		// save new state
	    List<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    oldList.remove(tdNumOfContact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	//@Test
	public void testDeleteAllContactsViaEditPage() {
		List<ContactData> contactList = appManager.getContactHelper().getContacts();
		
		for (int i = 0; i <= contactList.size() - 1; i++) {			
			int tdNumOfContact = 1;
			
			// save old state
			List<ContactData> oldList = appManager.getContactHelper().getContacts();
			
			// actions
			appManager.getContactHelper().openEditPageOfContact(tdNumOfContact);
			appManager.getContactHelper().deleteContact();
			appManager.getContactHelper().returnToHomePage();	
			
			// save new state
		    List<ContactData> newList = appManager.getContactHelper().getContacts();
		    
		    oldList.remove(tdNumOfContact);
		    Collections.sort(oldList);
		    assertEquals(newList, oldList);
		}
		
	}

}
