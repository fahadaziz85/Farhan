package com.farhan.pageobjects;

import com.farhan.basetestframework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage extends BasePage {
    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    // UI Elements / Locators
    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(id = "L2AGLb")
    private WebElement cookies_accept;

    public void acceptCookies() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
    }

    public void searchText(String text){

        searchBox.sendKeys(text);
        searchBox.submit();

    }
}
