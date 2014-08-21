package com.addressbook.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void testDeleteGroup() {
		appManager.getNavigationHelper().goToGroupsPage();
		
		// save old state
	    List<GroupData> oldList = appManager.getGroupHelper().getGroups();
	    
	    // actions
		appManager.getGroupHelper().deleteGroup(0);
		appManager.getGroupHelper().returnToGroupsPage();
		
		// save new state
	    List<GroupData> newList = appManager.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
