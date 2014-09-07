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
	appManager.getNavigationHelper().goToContactCreationPage();
    
	appManager.getContactHelper()
		.fillContactForm(contact)
		.submitContactCreation()
    	.returnToHomePage();
    
    // save new state
    List<ContactData> newList = appManager.getContactHelper().getContacts();
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
}

