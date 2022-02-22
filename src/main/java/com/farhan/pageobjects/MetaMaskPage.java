package com.farhan.pageobjects;

import com.farhan.basetestframework.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MetaMaskPage extends BasePage {
    public MetaMaskPage(WebDriver driver) {
        super(driver);

    }

    // UI Elements / Locators


    @FindBy(className = "btn-default")
    private WebElement unlockBtn;

    @FindBy(className = "page-container__footer-button")
    private WebElement confirmBtn;



    public void clickUnlockBtn(){
        unlockBtn.click();
    }

    public void clickConfirmBtn() throws InterruptedException {

        try {

            WebElement confirmbtn = driver.findElement(By.className("btn-primary"));
            confirmbtn.click();


        } catch (NoSuchWindowException e){
            System.out.println("NoSuchWindowException got handled");
        }
        Thread.sleep(30000);

    }
    public void enterPasswd() throws IOException {

        Properties prop = new Properties();
        FileInputStream loadFile = new FileInputStream("C:\\Users\\fbash\\IdeaProjects\\Farhan\\Config.properties");
        prop.load(loadFile);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(
                (By) By.id("password")));

        passwordField.sendKeys(prop.getProperty("password"));
    }
}
