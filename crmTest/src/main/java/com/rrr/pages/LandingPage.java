package com.rrr.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.rrr.base.TestBase;

import io.qameta.allure.Step;

public class LandingPage  extends TestBase{

	@FindBy(xpath="//a/span[text()='Log In']")
	WebElement loginButton;
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Step("Capturing page title")
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	@Step("Clicking login button on landing page")
	public LoginPage clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		return new LoginPage();
	}
	

	
}
