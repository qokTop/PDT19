package com.addressbook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class BaseHelper {
	
	protected ApplicationManager manager;
	protected WebDriver driver;
	
	public BaseHelper(ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;
	}

	protected void type(By locator, String text) {
		if (text != null) {
			driver.findElement(locator).clear();	    
			driver.findElement(locator).sendKeys(text);			
		}		
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if (text != null) {
			new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}
	
}
