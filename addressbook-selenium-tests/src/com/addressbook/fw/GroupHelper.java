package com.addressbook.fw;

import org.openqa.selenium.By;

import com.addressbook.tests.GroupData;

public class GroupHelper extends BaseHelper {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToGroupsPage() {	
	    click(By.linkText("group page"));
	}

	public void submitGroupCreation() {
	    click(By.name("submit"));
	}

	public void fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.name);
	    type(By.name("group_header"), group.header);
	    type(By.name("group_footer"), group.footer);
	}
	
	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
	}

	public void initModificationOfGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));		
	}

	public void modifyGroup(GroupData group) {
		type(By.name("group_name"), group.name);
		
	}

	public void submitGroupModification() {
		click(By.name("update"));			
	}

}
