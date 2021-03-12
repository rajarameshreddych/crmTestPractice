package com.rrr.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rrr.base.TestBase;
import com.rrr.pages.HomePage;
import com.rrr.pages.LandingPage;
import com.rrr.pages.LoginPage;

import junit.framework.Assert;

public class LandingPageTests extends TestBase {
	public LandingPageTests() {
		super();
	}
	
	LandingPage landing;
	LoginPage login;
	
//	@BeforeMethod
//	public void setUp() {
//		init();
//		landing = new LandingPage();
//	}
	
//	@AfterMethod
//	public void teardown() {
//		driver.quit();
//	}
//	
	//@Test(priority=1, retryAnalyzer = com.rrr.util.ReRunFailedTests_TestLevel.class)
	@Test(priority=1)
	public void validateLandingPageTitle() {
		landing = new LandingPage();
		String actualTitle = landing.getPageTitle();
		Assert.assertEquals("Title is not matched","#1 Free CRM customer relationship management software cloud", actualTitle);
	}
	
	@Test(priority=2)
	public void userShouldBeNavigatedToLoginPageOnClickingLoginButtonOnLangingPage() {
		landing = new LandingPage();
		login = landing.clickLogin();
		String homePageTitle = login.getPageTitle();
		Assert.assertEquals("Cogmento CRM", homePageTitle);
	}
	
}
