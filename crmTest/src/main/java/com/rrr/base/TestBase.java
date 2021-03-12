package com.rrr.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.rrr.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties config;
	public static EventFiringWebDriver eDriver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		config = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/rrr/config/Config.properties");
			config.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public static void init() {
		String browser = config.getProperty("browser");
		
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C://Users//rrreddy//Downloads//chromedriver_win32_88//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		eDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eDriver.register(eventListener);
		driver = eDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(config.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getProperty("implicitWaitTImeout")),TimeUnit.SECONDS);
		
		driver.get(config.getProperty("url"));
	}

	@AfterMethod
	public static void tearDown() {
		driver.quit();
	}

}
