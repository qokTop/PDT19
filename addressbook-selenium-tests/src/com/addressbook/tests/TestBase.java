package com.addressbook.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.addressbook.fw.ApplicationManager;

public class TestBase {
	
    protected static ApplicationManager appManager;
	
    @BeforeTest
	public void setUp() throws Exception {
		appManager = new ApplicationManager();	    
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		appManager.stop();	    
	}

}
