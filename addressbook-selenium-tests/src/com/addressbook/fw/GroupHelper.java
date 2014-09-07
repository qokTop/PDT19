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
	
	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper returnToGroupsPage() {	
	    click(By.linkText("group page"));
	    return this;
	}

	public GroupHelper submitGroupCreation() {
	    click(By.name("submit"));
	    return this;
	}

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
	    type(By.name("group_header"), group.getHeader());
	    type(By.name("group_footer"), group.getFooter());
	    return this;
	}
	
	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));
		return this;
	}

	public GroupHelper initModificationOfGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));	
		return this;
	}

	public GroupHelper modifyGroup(GroupData group) {
		type(By.name("group_name"), group.getName());
		return this;
		
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));		
		return this;
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");		
			String name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}

	public List<String> getGroupNonEmptyNames() {
		List<String> groupNames = new ArrayList<String>();
		List<GroupData> groups = getGroups();
		for (GroupData group : groups) {
			if (!group.getName().equals(""))
				groupNames.add(group.getName());
		}		
		return groupNames;
	}

}
