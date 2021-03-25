package com.rrr.tests;

import org.testng.annotations.Test;

import com.rrr.base.TestBase;
import com.rrr.pages.ContactsPage;
import com.rrr.pages.HomePage;
import com.rrr.pages.LandingPage;
import com.rrr.pages.LoginPage;

public class HomePageTests extends TestBase{
	
	public HomePageTests() {
		super();
	}
	
	LandingPage landing;
	LoginPage login;
	HomePage home;
	ContactsPage contacts;
	
	String username = config.getProperty("username");
	String password = config.getProperty("password");
	
	@Test(priority=1)
	public void userShouldBeRedirectedToContactsPageOnClickingContacts() {
		landing = new LandingPage();
		login = landing.clickLogin();
		home = login.validLogin(username, password);
		home.clickOnHome();
		contacts = home.clickOnContacts();
		System.out.println("test");
	}
}
