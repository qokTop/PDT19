package com.addressbook.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.addressbook.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testModifyGroup(GroupData group) {
		appManager.getNavigationHelper().goToGroupsPage();
		
		// save old state
		SortedListOf<GroupData> oldList = appManager.getGroupHelper().getGroups();	    
	    
	    // actions
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    appManager.getGroupHelper().modifyGroup(index, group);
		
		// save new state
	    SortedListOf<GroupData> newList = appManager.getGroupHelper().getGroups();
	    
	    // compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
	}
	
}

