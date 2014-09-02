package com.addressbook.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGeneratorForModification")
	public void testModifyContact(ContactData contact) {
		// save old state
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
		// actions
		appManager.getContactHelper().openEditPageOfContact(index);	
		appManager.getContactHelper().fillContactForm(contact);
		appManager.getContactHelper().submitContactModification();
		appManager.getContactHelper().returnToHomePage();
		
		// save new state
	    List<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	@Test(dataProvider = "randomValidContactGeneratorForModification")
	public void testModifyContactViaDetailsPage(ContactData contact) {
		// save old state
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
				
		// actions
		appManager.getContactHelper().viewDetailsOfContact(index);
		appManager.getContactHelper().initModificationOfContact();		
		appManager.getContactHelper().fillContactForm(contact);
		appManager.getContactHelper().submitContactModification();
		appManager.getContactHelper().returnToHomePage();
		
		// save new state
	    List<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	@Test(dataProvider = "provideGroupNonEmptyNames")
	public void testAddContactToGroup(List<String> groupNames) {
		String tdGroupNameAll = "[all]";
			
		// save old state
		Random rnd = new Random();
		int indexOfGroupName;
		if (groupNames.size() >= 2)
	        indexOfGroupName = rnd.nextInt(groupNames.size() - 1);
		else
			indexOfGroupName = 0;

		String groupName = groupNames.get(indexOfGroupName);
		appManager.getContactHelper().selectGroup(groupName);
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		// return back
		appManager.getContactHelper().selectGroup(tdGroupNameAll);
		
		// get the last name of modified contact
		ContactData contact = new ContactData();
		
		int index;
		if (oldList.size() >= 2)
	        index = rnd.nextInt(oldList.size() - 1);
		else
			index = 0;
		
		String lastNameOfModifiedContact = appManager.getContactHelper().getContactLastName(index);
		contact.lastName = lastNameOfModifiedContact;
						
		// actions
		appManager.getContactHelper().selectContact(index);		
		appManager.getContactHelper().selectGroupTo(groupName);
		appManager.getContactHelper().addContactToGroup();
		appManager.getContactHelper().returnToGroupPage(groupName);
		
		// save new state
		appManager.getContactHelper().selectGroup(groupName);
	    List<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    oldList.remove(index);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
	@Test(dataProvider = "provideGroupNonEmptyNames")
	public void testRemoveContactFromGroup(List<String> groupNames) {
		// save old state
		int indexOfGroupName;
		Random rnd = new Random();
		if (groupNames.size() >= 2)
	        indexOfGroupName = rnd.nextInt(groupNames.size() - 1);
		else
			indexOfGroupName = 0;

		String groupName = groupNames.get(indexOfGroupName);
		appManager.getContactHelper().selectGroup(groupName);
		List<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		// get the last name of modified contact
		ContactData contact = new ContactData();
		
		int index;
		if (oldList.size() >= 2)
	        index = rnd.nextInt(oldList.size() - 1);
		else
			index = 0;
	    
		String lastNameOfModifiedContact = appManager.getContactHelper().getContactLastName(index);
		contact.lastName = lastNameOfModifiedContact;
		
		// actions
		appManager.getContactHelper().selectContact(index);
		appManager.getContactHelper().removeFromGroup();
		appManager.getContactHelper().returnToGroupPage(groupName);
		appManager.getContactHelper().selectGroup(groupName);
		
		// save new state
	    List<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    oldList.remove(index);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
}

