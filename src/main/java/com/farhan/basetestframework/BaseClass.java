package com.farhan.basetestframework;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Arrays;

public class BaseClass {

	private WebDriver driver;

	@BeforeSuite
	public void beforeSuite() throws InterruptedException, IOException {
		//Change the path of the Chrome driver to your local machine Chrome driver
		// For Windows Machine add .exe at the end of the chromedriver
		//Runtime.getRuntime().exec("killall chromedriver");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		ChromeOptions options = new ChromeOptions();
		// For Mac
		//options.addArguments("user-data-dir=/Users/fahadaziz/Library/Application Support/Google/chrome/seleniumProfile");

		// For Windows
		//options.addArguments("user-data-dir=C:\\Users\\fbash\\AppData\\Local\\Google\\Chrome\\User Data\\");//seleniumProfile\\

		// For Mac
		//System.setProperty("webdriver.chrome.driver", "/Users/fahadaziz/Downloads/Softwares/chromedriver/chromedriver");

		// For Windows
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.get("https://play.crabada.com/mine");
		//Resize current window to the set dimension
		driver.manage().window().maximize();

		//To Delay execution for 10 sec. as to view the resize browser
		Thread.sleep(10000);
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
		//driver.quit();
	}

	
	public WebDriver getDriver() {
        return driver;
    }
}
