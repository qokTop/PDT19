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
	    for (int i = 0; i < 2; i++) {
	    	GroupData group = new GroupData()
	    		.withName(generateRandomString("name"))
	    		.withHeader(generateRandomString("header"))
	    		.withFooter(generateRandomString("footer"));
			list.add(new Object[]{group});
		}
	    return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
	    for (int i = 0; i < 2; i++) {		
	    	RandomDate randDate = new RandomDate();
			String date = randDate.getRandomDateAsString(1900, 1996); 
			
			ContactData contact = new ContactData()
				.withFirstName(generateRandomString("firstName"))
				.withLastName(generateRandomString("lastName"))
				.withAddress(generateRandomString("address"))
				.withHome(generateRandomString("home"))
				.withMobile(generateRandomString("mobile"))
				.withWork(generateRandomString("work"))
				.withEmail(generateRandomString("email"))
				.withEmail2(generateRandomString("email2"))
				.withBirthDay(randDate.getDayFromDate(date))
				.withBirthMonth(randDate.getMonthFromDate(date))
				.withBirthYear(randDate.getYearFromDate(date))		
				.withSecondaryAddress(generateRandomString("secondaryAddress"))
				.withSecondaryHome(generateRandomString("secondaryHome"));
			if (appManager.getContactHelper().CREATION) {
				appManager.getNavigationHelper().openMainPage();
				appManager.getNavigationHelper().goToGroupsPage();
				List<String> groupNames= appManager.getGroupHelper().getGroupNonEmptyNames();
				Random rnd = new Random();
				int indexOfGroupName;
				if (groupNames.size() >= 2)
					indexOfGroupName = rnd.nextInt(groupNames.size() - 1);
				else
					indexOfGroupName = 0;
				contact.withGroup(appManager.getGroupHelper().getGroupNonEmptyNames().get(indexOfGroupName));	
			}
				
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
