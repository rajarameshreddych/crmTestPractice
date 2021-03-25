package com.rrr.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rrr.base.TestBase;
import com.rrr.pages.HomePage;
import com.rrr.pages.LandingPage;
import com.rrr.pages.LoginPage;
import com.rrr.util.TestUtils;

import junit.framework.Assert;

public class LoginPageTests extends TestBase{
	
	public LoginPageTests() {
		super();
	}
	
	LandingPage landing;
	LoginPage login;
	HomePage home;
	
	String sheetName="CrmLoginData";
	
//	String username = config.getProperty("username");
//	String password = config.getProperty("password");
	
	
//	@BeforeMethod
//	public void setUp() {
//		init();
//		login = new LoginPage();
//	}
//	
//	@AfterMethod
//	public void teardown() {
//		driver.quit();
//	}
	
	
	@DataProvider
	public Object[][] getLoginData() {

		Object[][] data = TestUtils.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1)
	public void validateLoginPageTitle() {
		landing = new LandingPage();
		login = landing.clickLogin();
		
		String actualTitle = login.getPageTitle();
		Assert.assertEquals("Cogmento CRM", actualTitle);
	}
	
	@Test(priority=2, dataProvider="getLoginData")
	public void userShouldBeAbleToLoginWithValidCredentials(String username, String password) {
		landing = new LandingPage();
		login = landing.clickLogin();
		
		home = login.validLogin(username, password);
		
		String homePageTitle = home.getPageTitle();
		Assert.assertEquals("Cogmento CRM", homePageTitle);
	}
	
}
