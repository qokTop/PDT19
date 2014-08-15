package com.addressbook.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    appManager.getNavigationHelper().goToGroupsPage();
    appManager.getContactHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	appManager.getGroupHelper().fillGroupForm(group);
    appManager.getGroupHelper().submitGroupCreation();
    appManager.getGroupHelper().returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    appManager.getNavigationHelper().goToGroupsPage();
    appManager.getContactHelper().initGroupCreation();
    GroupData emptyGroup = new GroupData();
    emptyGroup.name = "";
    emptyGroup.header = "";
    emptyGroup.footer = "";
    appManager.getGroupHelper().fillGroupForm(emptyGroup);
    appManager.getGroupHelper().submitGroupCreation();
    appManager.getGroupHelper().returnToGroupsPage();
  }
  
}
