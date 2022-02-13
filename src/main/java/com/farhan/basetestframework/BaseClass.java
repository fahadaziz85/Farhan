package com.farhan.basetestframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	private WebDriver driver;

	@BeforeSuite
	public void beforeSuite(){
		//Change the path of the Chrome driver to your local machine Chrome driver
		// For Windows Machine add .exe at the end of the chromedriver
		System.setProperty("webdriver.chrome.driver", "/Users/f.aziz/Downloads/Softwares/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
	@BeforeClass
	public void beforeClass() {

		if (driver.toString()==null){
			driver = new ChromeDriver();
			driver.get("http://www.google.com");
		}
	}
	@AfterClass
	public void afterClass() {

	}

	@AfterSuite
	public void afterSuite(){
		driver.quit();
	}

	
	public WebDriver getDriver() {
        return driver;
    }
}
