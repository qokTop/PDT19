package com.addressbook.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.addressbook.utils.SortedListOf;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testModifyContact(ContactData contact) {
		// save old state
		SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();		
		
		// actions
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    appManager.getContactHelper().modifyContact(index, contact);
			
		// save new state
	    SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    // compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void testModifyContactViaDetailsPage(ContactData contact) {
		// save old state
		SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
				
		// actions
		appManager.getContactHelper()
			.viewDetailsOfContact(index)
			.initModificationOfContact()
			.fillContactForm(contact, appManager.getContactHelper().MODIFICATION)
			.submitContactModification()
			.returnToHomePage();
		
		// save new state
		SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}
	
	//@Test(dataProvider = "provideGroupNonEmptyNames")
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
		SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		// return back
		appManager.getContactHelper().selectGroup(tdGroupNameAll);
		
		int index;
		if (oldList.size() >= 2)
	        index = rnd.nextInt(oldList.size() - 1);
		else
			index = 0;
		
		String lastNameOfModifiedContact = appManager.getContactHelper().getContactLastName(index);
		
		// get the last name of modified contact
		ContactData contact = new ContactData()
			.withLastName(lastNameOfModifiedContact);
						
		// actions
		appManager.getContactHelper()
			.selectContact(index)
			.selectGroupTo(groupName)
			.addContactToGroup()
			.returnToGroupPage(groupName);
		
		// save new state
		appManager.getContactHelper().selectGroup(groupName);
		SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();
	    
		// compare states
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}
	
	//@Test(dataProvider = "provideGroupNonEmptyNames")
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
		SortedListOf<ContactData> oldList = appManager.getContactHelper().getContacts();
		
		int index;
		if (oldList.size() >= 2)
	        index = rnd.nextInt(oldList.size() - 1);
		else
			index = 0;
		
		// actions
		appManager.getContactHelper()
			.selectContact(index)
			.removeFromGroup()
			.returnToGroupPage(groupName)
			.selectGroup(groupName);
		
		// save new state
		SortedListOf<ContactData> newList = appManager.getContactHelper().getContacts();
	    
	    // compare states
		assertThat(newList, equalTo(oldList.without(index)));
	}
	
}

