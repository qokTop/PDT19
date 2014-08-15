package com.addressbook.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase {
	
	@Test
	public void testDeleteGroup() {
		appManager.getNavigationHelper().goToGroupsPage();
		appManager.getGroupHelper().deleteGroup(1);
		appManager.getGroupHelper().returnToGroupsPage();
	}

}
