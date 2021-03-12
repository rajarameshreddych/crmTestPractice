package com.rrr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rrr.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//*[@id=\"main-nav\"]/div[3]/a/i")
	WebElement contactsMenuIcon;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[5]/a/i")
	WebElement dealsMenuIcon;
	
	@FindBy(xpath="//span[text()='Raja C']")
	WebElement displayedUserName;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/div[1]/a/i")
	WebElement homeIcon;
	
	LandingPage landing;
	LoginPage login;
	HomePage home;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage loadHomePage(String userName, String password) {
		landing = new LandingPage();
		login = landing.clickLogin();
		home = login.login(userName, password);
		return home;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public HomePage clickOnHome() {
		homeIcon.click();
		return new HomePage();
	}
	
	public ContactsPage clickOnContacts() {
		contactsMenuIcon.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		dealsMenuIcon.click();
		return new DealsPage();
	}
	
	
	
}
