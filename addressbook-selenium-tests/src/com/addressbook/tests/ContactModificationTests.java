package com.addressbook.tests;

import org.testng.annotations.Test;

import com.addressbook.logic.RandomDate;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void testModifyContact() {
		int tdNumOfContact = 1;
		
		appManager.getContactHelper().openEditPageOfContact(tdNumOfContact);
		ContactData contact = new ContactData();
		contact.secondaryAddress = "new secondary address";
		contact.secondaryHome = "new secondary home";
		appManager.getContactHelper().fillContactForm(contact);
		appManager.getContactHelper().submitContactModification();
	}
	
	@Test
	public void testModifyContactViaDetailsPage() {
		int tdNumOfContact = 2;
		
		appManager.getContactHelper().viewDetailsOfContact(tdNumOfContact);
		appManager.getContactHelper().initModificationOfContact();	
		RandomDate randDate = new RandomDate();
		String date = randDate.getRandomDateAsString(1900, 1996);  
		ContactData contact = new ContactData();
		contact.birthDay = randDate.getDayFromDate(date);
		contact.birthMonth = randDate.getMonthFromDate(date);
		contact.birthYear = randDate.getYearFromDate(date);
		appManager.getContactHelper().fillContactForm(contact);
		appManager.getContactHelper().submitContactModification();
	}
	
	@Test
	public void testAddContactToGroup() {
		String tdGroupName = "group 1";
		int tdNumOfContact = 1;
		
		appManager.getContactHelper().selectContact(tdNumOfContact);
		appManager.getContactHelper().selectGroupTo(tdGroupName);
		appManager.getContactHelper().addContactToGroup();
		appManager.getContactHelper().returnToGroupPage(tdGroupName);
	}
	
	@Test
	public void testRemoveContactFromGroup() {
		String tdGroupName = "group 1";
		String tdGroupNameAll = "[all]";
		int tdNumOfContact = 1;
		
		appManager.getContactHelper().selectGroup(tdGroupName);
		appManager.getContactHelper().selectContact(tdNumOfContact);
		appManager.getContactHelper().removeFromGroup();
		appManager.getContactHelper().returnToGroupPage(tdGroupName);
		appManager.getContactHelper().selectGroup(tdGroupNameAll);
	}
	
}

