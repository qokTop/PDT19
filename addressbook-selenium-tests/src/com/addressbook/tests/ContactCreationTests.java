package com.addressbook.tests;

import org.testng.annotations.Test;

import com.addressbook.logic.RandomDate;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {    	
	openMainPage();
    goToContactCreationPage();
    
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
	
	fillContactForm(contact);
    submitContactCreation();
    goToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    goToContactCreationPage();
    ContactData emptyContact = new ContactData();
    emptyContact.birthDay = "-";
    emptyContact.birthMonth = "-";
    emptyContact.group = "[none]";
	fillContactForm(emptyContact);
    submitContactCreation();
    goToHomePage();
  }
  
}

