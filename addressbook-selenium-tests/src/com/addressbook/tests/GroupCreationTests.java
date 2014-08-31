package com.addressbook.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) {
	appManager.getNavigationHelper().goToGroupsPage();
    
    // save old state
    List<GroupData> oldList = appManager.getGroupHelper().getGroups();
    
    // actions
    appManager.getContactHelper().initGroupCreation();
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
  
}
