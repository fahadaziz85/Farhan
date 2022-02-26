package com.farhan.pageobjects;

import com.farhan.basetestframework.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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
        // Right now this code is ideal for only one team
        Thread.sleep(14400000); // wait for 4 hours until finish button appears
        WebDriverWait wait = new WebDriverWait(driver, 14400000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("timing")));
        driver.navigate().refresh();
    }

    public void clickSelectBtn(){
        WebElement selectBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/div/button"));
        selectBtn.sendKeys(Keys.RETURN);
    }

    // CLICK REINFORCEMENT
    public void clickReinforce() throws InterruptedException {
        List<WebElement> underAttack = driver.findElements(By.className("mine-status"));

        for (WebElement el: underAttack
             ) {
            System.out.println("innerHTML: " + el.getAttribute("innerHTML"));
            if (el.getAttribute("innerHTML").contains("Under Attack") ){
                new Actions(driver).moveToElement(el).click().perform();
                break;
            }
        }

        //WebDriverWait wait = new WebDriverWait(driver, 8);
        //WebElement hireBtn = driver.findElement(By.className("shop-store"));
        //hireBtn.sendKeys(Keys.RETURN); // to click Hire button
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
        driver.switchTo().defaultContent();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("shop-add")));
        Thread.sleep(5000);
        List <WebElement> BtnList = driver.findElements(By.tagName("button"));
        for (WebElement btn:BtnList
             ) {
            Thread.sleep(3000);
            if (btn.getAttribute("innerHTML").contains("Add")){
                btn.sendKeys(Keys.RETURN);
                break;
            }
        }

        // grab all the images in the given div then compare its src value and then select them
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("slick-list")));
        ArrayList<String> popups = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Popups handles size = " + popups.size());
        WebElement crabsList = driver.findElement(By.className("slick-list"));
        WebElement firstCrab = crabsList.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div"));
       // WebElement secondCrab = crabsList.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div/div/div/div[2]/div/div/div"));
        if (firstCrab.isDisplayed()){
            new Actions(driver).moveToElement(firstCrab).click().perform();
            WebElement addCrab = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div/div[2]/button"));
            addCrab.click();
        }
        // This logic can be used later but the upper side code is efficient
        /*List<WebElement> crabsListArray = crabsList.findElements(By.tagName("img"));
        System.out.println("Crabs list in reinforcement page has size: " + crabsListArray.size());
        for (WebElement crab:crabsListArray) {
            System.out.println("Crab image innerHTML" + crab.getAttribute("innerHTML"));
            if (crab.getAttribute("src").equalsIgnoreCase("https://photos.crabada.com/30468.png") )   {
                new Actions(driver).moveToElement(crab).click().perform();
                System.out.println("First image clicked");
                break;
            } else if (crab.getAttribute("src").equalsIgnoreCase("https://photos.crabada.com/24885.png") ){
                new Actions(driver).moveToElement(crab).click().perform();
                System.out.println("Second image clicked");
                break;
            }else if (crab.getAttribute("src").equalsIgnoreCase("https://photos.crabada.com/32762.png")){
                new Actions(driver).moveToElement(crab).click().perform();
                System.out.println("Third image clicked");
                break;
            }
        }*/




    }


}
