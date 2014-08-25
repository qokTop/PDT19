package com.addressbook.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.addressbook.logic.RandomDate;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {    
	// save old state
	List<ContactData> oldList = appManager.getContactHelper().getContacts();
    
    // actions
	appManager.getNavigationHelper().goToContactCreationPage();
    ContactData contact = new ContactData();   
	contact.firstName = "firstName";
	contact.lastName = "lastName";
	contact.address = "address";
	contact.home = "home";
	contact.mobile = "mobile";
	contact.work = "work";
	contact.email = "e-mail";
	contact.email2 = "e-mail2";
	RandomDate randDate = new RandomDate();
	String date = randDate.getRandomDateAsString(1900, 1996);  
	contact.birthDay = randDate.getDayFromDate(date);
	contact.birthMonth = randDate.getMonthFromDate(date);
	contact.birthYear = randDate.getYearFromDate(date);
	contact.group = "group 1";
	contact.secondaryAddress = "secondaryAddress";
	contact.secondaryHome = "secondaryHome";
	
	appManager.getContactHelper().fillContactForm(contact);
    appManager.getContactHelper().submitContactCreation();
    appManager.getContactHelper().returnToHomePage();
    
    // save new state
    List<ContactData> newList = appManager.getContactHelper().getContacts();
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	  
	// save old state
	List<ContactData> oldList = appManager.getContactHelper().getContacts();
	
	// actions
    appManager.getNavigationHelper().goToContactCreationPage();
    ContactData emptyContact = new ContactData();
    emptyContact.firstName = "";
	emptyContact.lastName = "";
	emptyContact.address = "";
	emptyContact.home = "";
	emptyContact.mobile = "";
	emptyContact.work = "";
	emptyContact.email = "";
	emptyContact.email2 = "";
    emptyContact.birthDay = "-";
    emptyContact.birthMonth = "-";
    emptyContact.group = "[none]";
    emptyContact.secondaryAddress = "";
    emptyContact.secondaryHome = "";
    
    appManager.getContactHelper().fillContactForm(emptyContact);
    appManager.getContactHelper().submitContactCreation();
    appManager.getContactHelper().returnToHomePage();
    
    // save new state
    List<ContactData> newList = appManager.getContactHelper().getContacts();
    
    oldList.add(emptyContact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
}

