package com.addressbook.tests;

import org.testng.annotations.Test;

import com.addressbook.utils.SortedListOf;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactCreationTests extends TestBase {

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) {    
	// save old state
	SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();
    
    // actions
	appManager.getContactHelper().createContact(contact);
	   
    // save new state
	SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();
    
    // compare states
	assertThat(newList, equalTo(oldList.withAdded(contact)));
  }
  
}

