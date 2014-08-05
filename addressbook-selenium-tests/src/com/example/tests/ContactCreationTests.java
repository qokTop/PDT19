package com.example.tests;

import org.testng.annotations.Test;

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
    contact.birthDay = "1";
    contact.birthMonth = "January";
    contact.birthYear = "2000";
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

