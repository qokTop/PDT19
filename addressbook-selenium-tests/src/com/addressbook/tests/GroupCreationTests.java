package com.addressbook.tests;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	appManager.getNavigationHelper().goToGroupsPage();
    
    // save old state
    List<GroupData> oldList = appManager.getGroupHelper().getGroups();
    
    // actions
    appManager.getContactHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	appManager.getGroupHelper().fillGroupForm(group);
    appManager.getGroupHelper().submitGroupCreation();
    appManager.getGroupHelper().returnToGroupsPage();
    
    // save new state
    List<GroupData> newList = appManager.getGroupHelper().getGroups();
    
    // compare states
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
    appManager.getNavigationHelper().goToGroupsPage();
    
    // save old state
    List<GroupData> oldList = appManager.getGroupHelper().getGroups();
    
    // actions
    appManager.getContactHelper().initGroupCreation();
    GroupData emptyGroup = new GroupData();
    emptyGroup.name = "";
    emptyGroup.header = "";
    emptyGroup.footer = "";
    appManager.getGroupHelper().fillGroupForm(emptyGroup);
    appManager.getGroupHelper().submitGroupCreation();
    appManager.getGroupHelper().returnToGroupsPage();
    
    // save new state
    List<GroupData> newList = appManager.getGroupHelper().getGroups();
    
    // compare states
    oldList.add(emptyGroup);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
}
