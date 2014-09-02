package com.addressbook.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
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

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");		
			group.name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(group);
		}
		return groups;
	}

	public List<String> getGroupNonEmptyNames() {
		List<String> groupNames = new ArrayList<String>();
		List<GroupData> groups = getGroups();
		for (GroupData group : groups) {
			if (!group.name.equals(""))
				groupNames.add(group.name);
		}		
		return groupNames;
	}

}
