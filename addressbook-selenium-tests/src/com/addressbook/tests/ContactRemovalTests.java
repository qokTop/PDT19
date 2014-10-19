package com.addressbook.tests;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.addressbook.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void testDeleteContactViaEditPage() {		
		// save old state
		SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		// actions
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    appManager.getContactHelper().deleteContact(index);
		
		// save new state
	    SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    // compare states
	    oldList.remove(index);
	    assertEquals(newList, oldList);
	}
	
	//@Test
	public void testDeleteAllContactsViaEditPage() {
		SortedListOf<ContactData> contactList = appManager.getContactHelper().getContacts();
		
		for (int i = 0; i <= contactList.size() - 1; i++) {			
			int tdNumOfContact = 1;
			
			// save old state
			SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();
			
			// actions
			appManager.getContactHelper().deleteContact(tdNumOfContact);	
			
			// save new state
			SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();
		    
		    // compare states
		    oldList.remove(tdNumOfContact);
		    assertEquals(newList, oldList);
		}
		
	}

}
