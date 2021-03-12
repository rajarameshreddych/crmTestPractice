package com.rrr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rrr.base.TestBase;

public class LandingPage  extends TestBase{

	@FindBy(xpath="//a/span[text()='Log In']")
	WebElement loginButton;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage clickLogin() {
		loginButton.click();
		return new LoginPage();
	}
	

	
}
