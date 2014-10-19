package com.addressbook.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.addressbook.utils.SortedListOf;

public class GroupCreationTests extends TestBase {

  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) {
	appManager.getNavigationHelper().goToGroupsPage();
	  
    // save old state
	SortedListOf<GroupData> oldList = appManager.getGroupHelper().getGroups();
    
    //actions
    appManager.getGroupHelper().createGroup(group);
    
    // save new state
    SortedListOf<GroupData> newList = appManager.getGroupHelper().getGroups();
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }
  
}
