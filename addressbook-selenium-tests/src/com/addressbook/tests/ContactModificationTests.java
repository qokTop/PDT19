package com.addressbook.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.addressbook.logic.RandomDate;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void testModifyContact() {
		int tdNumOfContact = 0;
		
		// save old state
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		// actions
		appManager.getContactHelper().openEditPageOfContact(tdNumOfContact);
		ContactData contact = new ContactData();
		contact.lastName = "newLastName";
		contact.secondaryAddress = "newSecondaryAddress";
		contact.secondaryHome = "newSecondaryHome";		
		appManager.getContactHelper().fillContactForm(contact);
		appManager.getContactHelper().submitContactModification();
		appManager.getContactHelper().returnToHomePage();
		
		// save new state
	    List<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    oldList.remove(tdNumOfContact);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	public void testModifyContactViaDetailsPage() {
		int tdNumOfContact = 1;
		
		// save old state
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
				
		// actions
		appManager.getContactHelper().viewDetailsOfContact(tdNumOfContact);
		appManager.getContactHelper().initModificationOfContact();		
		RandomDate randDate = new RandomDate();	
		String date = randDate.getRandomDateAsString(1900, 1996);
		ContactData contact = new ContactData();
		contact.lastName = "newLastName";
		contact.birthDay = randDate.getDayFromDate(date);
		contact.birthMonth = randDate.getMonthFromDate(date);
		contact.birthYear = randDate.getYearFromDate(date);
		appManager.getContactHelper().fillContactForm(contact);
		appManager.getContactHelper().submitContactModification();
		appManager.getContactHelper().returnToHomePage();
		
		// save new state
	    List<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    oldList.remove(tdNumOfContact);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	public void testAddContactToGroup() {
		String tdGroupName = "group 1";
		String tdGroupNameAll = "[all]";
		int tdNumOfContact = 0;
		
		// save old state
		appManager.getContactHelper().selectGroup(tdGroupName);
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		// return back
		appManager.getContactHelper().selectGroup(tdGroupNameAll);
		
		// get the last name of modified contact
		ContactData contact = new ContactData();
		String lastNameOfModifiedContact = appManager.getContactHelper().getContactLastName(tdNumOfContact);
		contact.lastName = lastNameOfModifiedContact;
						
		// actions
		appManager.getContactHelper().selectContact(tdNumOfContact);		
		appManager.getContactHelper().selectGroupTo(tdGroupName);
		appManager.getContactHelper().addContactToGroup();
		appManager.getContactHelper().returnToGroupPage(tdGroupName);
		
		// save new state
		appManager.getContactHelper().selectGroup(tdGroupName);
	    List<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    oldList.remove(tdNumOfContact);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	public void testRemoveContactFromGroup() {
		String tdGroupName = "group 1";
		int tdNumOfContact = 0;
		
		appManager.getContactHelper().selectGroup(tdGroupName);
								
		// save old state
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		// get the last name of modified contact
		ContactData contact = new ContactData();
		String lastNameOfModifiedContact = appManager.getContactHelper().getContactLastName(tdNumOfContact);
		contact.lastName = lastNameOfModifiedContact;
		
		// actions
		appManager.getContactHelper().selectContact(tdNumOfContact);
		appManager.getContactHelper().removeFromGroup();
		appManager.getContactHelper().returnToGroupPage(tdGroupName);
		appManager.getContactHelper().selectGroup(tdGroupName);
		
		// save new state
	    List<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    oldList.remove(tdNumOfContact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
}

