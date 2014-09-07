package com.addressbook.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.addressbook.tests.ContactData;

public class ContactHelper extends BaseHelper {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.getFirstName());
		type(By.name("lastname"), contact.getLastName());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBirthDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
	    selectByText(By.name("new_group"), contact.getGroup());
	    type(By.name("address2"), contact.getSecondaryAddress());
	    type(By.name("phone2"), contact.getSecondaryHome());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper openEditPageOfContact(int index) {
		click(By.xpath("//tbody/tr[" + (index + 2) + "]/td[7]/a"));
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.name("update"));	
		return this;
	}

	public ContactHelper viewDetailsOfContact(int index) {
		click(By.xpath("//tbody/tr[" + (index + 2) + "]/td[6]/a"));		
		return this;
	}

	public ContactHelper initModificationOfContact() {
		click(By.name("modifiy"));		
		return this;
	}

	public ContactHelper selectGroup(String groupName) {
		click(By.xpath("//select[@name='group']/option[text()='" + groupName +"'][1]"));	
		return this;
	}

	public ContactHelper removeFromGroup() {
		click(By.name("remove"));
		return this;
	}

	public ContactHelper selectContact(int index) {
		click(By.xpath("//tbody/tr[" + (index + 2) + "]/td[1]/input"));	
		return this;
	}

	public ContactHelper returnToGroupPage(String groupName) {
		click(By.linkText("group page " + '"' + groupName + '"'));		
		return this;
	}

	public ContactHelper selectGroupTo(String groupName) {
		click(By.xpath("//select[@name='to_group']/option[text()='" + groupName +"'][1]"));	
		return this;
	}

	public ContactHelper addContactToGroup() {
		click(By.name("add"));		
		return this;
	}

	public ContactHelper deleteContact() {
		click(By.xpath("//div//form[2]/input[@name='update']"));
		return this;
	}

	public List<ContactData> getContacts() {
		/*List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			ContactData contact = new ContactData();
			String title = checkbox.getAttribute("title");
			String firstLastNames = title.substring("Select (".length(), title.length() - ")".length());	
			//contact.firstName = firstLastNames.substring(0, firstLastNames.indexOf(" ") - 1);
			contact.lastName = firstLastNames.substring(firstLastNames.indexOf(" ") + 1, firstLastNames.length());
			contacts.add(contact);
		{
		return contacts;*/
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {			
		    ContactData contact = new ContactData()
		    // FIXME There are incorrectly columns in the table: lastName and firstname
		    //       change objects after fixing
		    .withFirstName(row.findElement(By.xpath(".//td[3]")).getText())
		    .withLastName(row.findElement(By.xpath(".//td[2]")).getText());
		   /* contact.firstName = row.findElement(By.xpath(".//td[3]")).getText();
		    contact.lastName  = row.findElement(By.xpath(".//td[2]")).getText();*/
		    contacts.add(contact);
		}
		return contacts;
	}
	
	private List<WebElement> getContactRows() {
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		rows.remove(0);
		rows.remove(rows.size() - 1);
		return rows;		
	}

	public String getContactLastName(int index) {
		return driver.findElement(By.xpath("//tbody//tr[" + (index + 2) +"]//td[2]")).getText();
	}

}
