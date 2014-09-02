package com.addressbook.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.addressbook.fw.ApplicationManager;
import com.addressbook.logic.RandomDate;

public class TestBase {
	
    protected static ApplicationManager appManager;
    
    @BeforeMethod
    public void beforeTestMethod() throws Exception {
    	appManager.getNavigationHelper().openMainPage();	    
	}
	
    @BeforeTest
	public void setUp() throws Exception {
		appManager = new ApplicationManager();	    
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		appManager.stop();	    
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
	    for (int i = 0; i < 4; i++) {
	    	GroupData group = new GroupData();
			group.name = generateRandomString("name");
			group.header = generateRandomString("header");
			group.footer = generateRandomString("footer");
			list.add(new Object[]{group});
		}
	    return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
	    for (int i = 0; i < 4; i++) {			
			ContactData contact = new ContactData();   
			contact.firstName = generateRandomString("firstName");
			contact.lastName = generateRandomString("lastName");
			contact.address = generateRandomString("address");
			contact.home = generateRandomString("home");
			contact.mobile = generateRandomString("mobile");
			contact.work = generateRandomString("work");
			contact.email = generateRandomString("e-mail");
			contact.email2 = generateRandomString("e-mail2");
			RandomDate randDate = new RandomDate();
			String date = randDate.getRandomDateAsString(1900, 1996);  
			contact.birthDay = randDate.getDayFromDate(date);
			contact.birthMonth = randDate.getMonthFromDate(date);
			contact.birthYear = randDate.getYearFromDate(date);
			
			appManager.getNavigationHelper().openMainPage();
			appManager.getNavigationHelper().goToGroupsPage();
			List<String> groupNames= appManager.getGroupHelper().getGroupNonEmptyNames();
			Random rnd = new Random();
			int indexOfGroupName;
			if (groupNames.size() >= 2)
		        indexOfGroupName = rnd.nextInt(groupNames.size() - 1);
			else
				indexOfGroupName = 0;
			contact.group = appManager.getGroupHelper().getGroupNonEmptyNames().get(indexOfGroupName);
			
			contact.secondaryAddress = generateRandomString("secondaryAddress");
			contact.secondaryHome = generateRandomString("secondaryHome");
			list.add(new Object[]{contact});
		}
	    return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGeneratorForModification() {
		List<Object[]> list = new ArrayList<Object[]>();
	    for (int i = 0; i < 4; i++) {			
			ContactData contact = new ContactData();   
			contact.firstName = generateRandomString("firstName");
			contact.lastName = generateRandomString("lastName");
			contact.address = generateRandomString("address");
			contact.home = generateRandomString("home");
			contact.mobile = generateRandomString("mobile");
			contact.work = generateRandomString("work");
			contact.email = generateRandomString("e-mail");
			contact.email2 = generateRandomString("e-mail2");
			RandomDate randDate = new RandomDate();
			String date = randDate.getRandomDateAsString(1900, 1996);  
			contact.birthDay = randDate.getDayFromDate(date);
			contact.birthMonth = randDate.getMonthFromDate(date);
			contact.birthYear = randDate.getYearFromDate(date);
			
			contact.secondaryAddress = generateRandomString("secondaryAddress");
			contact.secondaryHome = generateRandomString("secondaryHome");
			list.add(new Object[]{contact});
		}
	    return list.iterator();
	}
	  
	private String generateRandomString(String fixString) {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0)
			return "";
		else
			return fixString + rnd.nextInt();
	}

	@DataProvider
	public Iterator<Object[]> provideGroupNonEmptyNames() {
		List<Object[]> list = new ArrayList<Object[]>();
		appManager.getNavigationHelper().openMainPage();
		appManager.getNavigationHelper().goToGroupsPage();
		list.add(new Object[]{appManager.getGroupHelper().getGroupNonEmptyNames()});
		return list.iterator();
	}
}
