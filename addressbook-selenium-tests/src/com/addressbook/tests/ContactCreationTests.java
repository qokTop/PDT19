package com.addressbook.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) {    
	// save old state
	List<ContactData> oldList = appManager.getContactHelper().getContacts();
    
    // actions
	appManager.getContactHelper().createContact(contact);
	   
    // save new state
    List<ContactData> newList = appManager.getContactHelper().getContacts();
    
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
}

