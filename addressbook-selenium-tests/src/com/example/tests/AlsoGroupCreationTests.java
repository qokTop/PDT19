package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreationTests extends TestBase {

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    goToGroupsPage();
    initGroupCreation();
    ValueObject group = new ValueObject();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openMainPage();
    goToGroupsPage();
    initGroupCreation();
    fillGroupForm(new ValueObject("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }

}
