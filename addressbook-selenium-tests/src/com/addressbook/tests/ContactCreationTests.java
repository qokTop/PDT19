package com.addressbook.tests;

import org.testng.annotations.Test;

import com.addressbook.logic.RandomDate;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {    	
	appManager.getNavigationHelper().openMainPage();
    appManager.getNavigationHelper().goToContactCreationPage();
    
    ContactData contact = new ContactData();   
	contact.firstName = "firstName value";
	contact.lastName = "lastName value";
	contact.address = "address value";
	contact.home = "home value";
	contact.mobile = "mobile value";
	contact.work = "work value";
	contact.email = "e-mail value";
	contact.email2 = "e-mail2 value";
	RandomDate randDate = new RandomDate();
	String date = randDate.getRandomDateAsString(1900, 1996);  
	contact.birthDay = randDate.getDayFromDate(date);
	contact.birthMonth = randDate.getMonthFromDate(date);
	contact.birthYear = randDate.getYearFromDate(date);
	contact.group = "group 1";
	contact.secondaryAddress = "secondaryAddress value";
	contact.secondaryHome = "secondaryHome value";
	
	appManager.getContactHelper().fillContactForm(contact);
    appManager.getContactHelper().submitContactCreation();
    appManager.getContactHelper().returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	appManager.getNavigationHelper().openMainPage();
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
  }
  
}

