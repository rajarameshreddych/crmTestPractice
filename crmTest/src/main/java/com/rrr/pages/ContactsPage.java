package com.rrr.pages;

import org.openqa.selenium.support.PageFactory;

import com.rrr.base.TestBase;

public class ContactsPage extends TestBase {

	HomePage home;
	ContactsPage contactsPage;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ContactsPage loadContactsPage(String userName, String password) {
		home = new HomePage();
		home = home.loadHomePage(config.getProperty("username"), config.getProperty("password"));
		contactsPage = home.clickOnContacts();
		return contactsPage;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	
}
