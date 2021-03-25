package com.rrr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.rrr.base.TestBase;

public class LoginPage  extends TestBase{

	LandingPage landing;
	LoginPage login;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginButton;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage loadLoginPage() {
		landing = new LandingPage();
		login = landing.clickLogin();
		return login;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage validLogin(String email1, String password1) {
		email.sendKeys(email1);
		password.sendKeys(password1);
		loginButton.click();
		
		return new HomePage();
	}
	
		
}
