package com.addressbook.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	
	@Test
	public void testModifyGroup() {
		appManager.getNavigationHelper().openMainPage();
		appManager.getNavigationHelper().goToGroupsPage();
		appManager.getGroupHelper().initModificationOfGroup(1);
		GroupData group = new GroupData();
		group.name = "new name";
		appManager.getGroupHelper().fillGroupForm(group);
		appManager.getGroupHelper().submitGroupModification();
	}
	
}

