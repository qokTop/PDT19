package com.addressbook.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void testDeleteGroup() {
		appManager.getNavigationHelper().goToGroupsPage();
		
		// save old state
	    List<GroupData> oldList = appManager.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
	    // actions
		appManager.getGroupHelper()
			.deleteGroup(index)
			.returnToGroupsPage();
		
		// save new state
	    List<GroupData> newList = appManager.getGroupHelper().getGroups();
	    
	    // compare states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}

}
