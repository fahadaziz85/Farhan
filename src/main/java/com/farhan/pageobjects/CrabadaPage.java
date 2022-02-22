package com.farhan.pageobjects;

import com.farhan.basetestframework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrabadaPage extends BasePage {
    public CrabadaPage(WebDriver driver) {
        super(driver);
    }

    // UI Elements / Locators
    @FindBy(className = "btn-ok")
    private WebElement connectWallet;
    @FindBy(className = "ant-btn")
    private WebElement connectWalletLeftMenuButton;
   /* @FindBy(xpath = "//span[contains(text(), 'Claim')]")
    private WebElement claimButton;*/
    @FindBy(className = "menu")
    WebElement menu;



    public void clickConnectWallet(){
        connectWallet.click();
    }

    public void clickClaimButton() throws InterruptedException {
        Thread.sleep(5000);
        WebElement claimButton = driver.findElement(By.xpath("//*[@id=\"rc-tabs-0-panel-1\"]/div[2]/div/div/div[3]/div/button"));
        boolean flag = claimButton.isDisplayed();
        if (flag){

            claimButton.sendKeys(Keys.RETURN);
        }

    }

    public void clickDashboard(){
        driver.get("https://play.crabada.com");

    }

    public void clickMiningExpedition(){
        driver.get("https://play.crabada.com/mine");

    }

    public void clickStartMiningExpeditionsBtn() {

        WebElement btn =driver.findElement(By.xpath("//button[text()= 'Start Mining Expeditions']"));
        if (btn.isDisplayed() && btn.isEnabled()){
            btn.sendKeys(Keys.RETURN);;
        }

        /*WebElement historyBtn = driver.findElement(By.xpath("/html/body/div/div/div/section/main/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[1]/button"));
        historyBtn.click(); historyBtn.click(); historyBtn.click(); historyBtn.click();*/

    }
    public void clickConnectWalletLeftMenuButton(){
        boolean flag=connectWalletLeftMenuButton.isDisplayed();

        if (flag){
            connectWalletLeftMenuButton.sendKeys(Keys.RETURN);
        }
    }

    public void waitForMininigExpeditionToBeFinished() throws InterruptedException {
        Thread.sleep(10200000);
        WebDriverWait wait = new WebDriverWait(driver, 14400000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("timing")));
        driver.navigate().refresh();
    }

    public void clickSelectBtn(){
        WebElement selectBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/div/button"));
        selectBtn.sendKeys(Keys.RETURN);
    }


}
