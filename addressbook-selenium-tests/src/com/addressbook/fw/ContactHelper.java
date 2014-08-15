package com.addressbook.fw;

import org.openqa.selenium.By;

import com.addressbook.tests.ContactData;

public class ContactHelper extends BaseHelper {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
		type(By.name("lastname"), contact.lastName);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.work);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.birthDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    selectByText(By.name("new_group"), contact.group);
	    type(By.name("address2"), contact.secondaryAddress);
	    type(By.name("phone2"), contact.secondaryHome);
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void openEditPageOfContact(int index) {
		click(By.xpath("//tbody/tr[" + (index + 1) + "]/td[7]/a"));
	}

	public void submitContactModification() {
		click(By.name("update"));		
	}

	public void viewDetailsOfContact(int index) {
		click(By.xpath("//tbody/tr[" + (index + 1) + "]/td[6]/a"));		
	}

	public void initModificationOfContact() {
		click(By.name("modifiy"));		
	}

	public void selectGroup(String groupName) {
		click(By.xpath("//select[@name='group']/option[text()='" + groupName +"'][1]"));		
	}

	public void removeFromGroup() {
		click(By.name("remove"));		
	}

	public void selectContact(int index) {
		click(By.xpath("//tbody/tr[" + (index + 1) + "]/td[1]/input"));		
	}

	public void returnToGroupPage(String groupName) {
		click(By.linkText("group page " + '"' + groupName + '"'));		
	}

	public void selectGroupTo(String groupName) {
		click(By.xpath("//select[@name='to_group']/option[text()='" + groupName +"'][1]"));		
	}

	public void addContactToGroup() {
		click(By.name("add"));		
	}

	public void deleteContact() {
		click(By.xpath("//div//form[2]/input[@name='update']"));	
	}

}
