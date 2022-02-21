package com.farhan.pageobjects;

import com.farhan.basetestframework.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CrabadaPage extends BasePage {
    public CrabadaPage(WebDriver driver) {
        super(driver);
    }

    // UI Elements / Locators
    @FindBy(className = "btn-ok")
    private WebElement connectWallet;
    @FindBy(className = "ant-btn")
    private WebElement connectWalletLeftMenuButton;



    public void clickConnectWallet(){
        connectWallet.click();
    }

    public void clickConnectWalletLeftMenuButton(){
        boolean flag=connectWalletLeftMenuButton.isDisplayed();

        if (flag){
            connectWalletLeftMenuButton.sendKeys(Keys.RETURN);
        }
    }


}
