package com.farhan.pageobjects;

import com.farhan.basetestframework.BasePage;
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
    @FindBy(className = "password")
    private WebElement metaMaskPasswd;


    public void clickConnectWallet(){
        connectWallet.click();
    }

    public void clickConnectWalletLeftMenuButton(){
        connectWalletLeftMenuButton.click();
    }

    public void enterMetaMaskPassword(String passwd){
        metaMaskPasswd.sendKeys(passwd);
    }
}
