package com.addressbook.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void testModifyGroup() {
		appManager.getNavigationHelper().goToGroupsPage();
		
		// save old state
	    List<GroupData> oldList = appManager.getGroupHelper().getGroups();
	    
	    // actions
		appManager.getGroupHelper().initModificationOfGroup(0);
		GroupData group = new GroupData();
		group.name = "new name";
		appManager.getGroupHelper().fillGroupForm(group);
		appManager.getGroupHelper().submitGroupModification();
		appManager.getGroupHelper().returnToGroupsPage();
		
		// save new state
	    List<GroupData> newList = appManager.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.remove(0);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
	
}

