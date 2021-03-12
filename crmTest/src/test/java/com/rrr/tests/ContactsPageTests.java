package com.rrr.tests;

import org.testng.annotations.Test;

import com.rrr.base.TestBase;
import com.rrr.pages.ContactsPage;
import com.rrr.pages.HomePage;
import com.rrr.pages.LandingPage;
import com.rrr.pages.LoginPage;

import junit.framework.Assert;

public class ContactsPageTests extends TestBase{
	
	public ContactsPageTests() {
		super();
	}
	
	LandingPage landing;
	LoginPage login;
	HomePage home;
	ContactsPage contactsPage;
	
	String username = config.getProperty("username");
	String password = config.getProperty("password");
	
	@Test
	public void validateContactsPageURL() {
		String exp = "https://ui.cogmento.com/contacts";
		contactsPage = new ContactsPage();
		contactsPage.loadContactsPage(username, password);
		String act = contactsPage.getPageURL();
		Assert.assertEquals("URL not matched", exp, act);
	}

}
