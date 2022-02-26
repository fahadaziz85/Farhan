package com.farhan.regressiontests;

import com.farhan.basetestframework.BaseClass;
import com.farhan.pageobjects.CrabadaPage;
import com.farhan.pageobjects.MetaMaskPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.lang.management.ThreadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class CrabadaAutomationTest extends BaseClass {

    private int counter = 0;


    @Test(priority = 1)
    public void startMiningExpeditionsWorkflow() throws InterruptedException, IOException {
        CrabadaPage crab = new CrabadaPage(getDriver());
        MetaMaskPage mask = new MetaMaskPage(getDriver());
        if (counter == 0) {
            ((JavascriptExecutor) getDriver()).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
            getDriver().switchTo().window(tabs.get(1));
            getDriver().get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#unlock");

            mask.enterPasswd();
            mask.clickUnlockBtn();
            Thread.sleep(3000);
            getDriver().close();
            getDriver().switchTo().window(tabs.get(0));  // switch back to parent window
            crab.clickDashboard();
            Thread.sleep(3000);
            crab.clickMiningExpedition();
            Thread.sleep(5000);


        }
        /*crab.clickStartMiningExpeditionsBtn();
        Thread.sleep(5000);
        crab.clickSelectBtn();
        this.confirmMetaMaskTransaction(mask);
        Thread.sleep(5000);
        System.out.println("Counter value: "+ counter++);*/
        getDriver().navigate().refresh();getDriver().navigate().refresh();




    }

    @Test(priority = 2)
    public void testReinforceFunctionality() throws InterruptedException {
        CrabadaPage crab = new CrabadaPage(getDriver());
        MetaMaskPage mask = new MetaMaskPage(getDriver());
        Thread.sleep(5000);
        for (int i= 0; i <2; i++) {
            //boolean reinforceArea = getDriver().findElement(By.className("mine-status")).getAttribute("innerHTML").equals("Ending");
            Thread.sleep(5000);
            WebElement reinforceArea = getDriver().findElement(By.className("mine-status"));
            if (reinforceArea.isDisplayed()) {
                Thread.sleep(3000);
                crab.clickReinforce();
                Thread.sleep(5000);
                this.confirmMetaMaskTransaction(mask);
                Thread.sleep(5000);
                getDriver().navigate().refresh();
                getDriver().get("https://play.crabada.com/mine");
            }
        }
    }

   // @Test(priority = 3)
    public void claimRewardWorkFlow() throws InterruptedException, IOException {
        CrabadaPage crab = new CrabadaPage(getDriver());
        MetaMaskPage mask = new MetaMaskPage(getDriver());
        if (counter == 0) {
            ((JavascriptExecutor) getDriver()).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
            getDriver().switchTo().window(tabs.get(1));
            getDriver().get("chrome-extension://nkbihfbeogaeaoehlefnkodbefgpgknn/home.html#unlock");

            mask.enterPasswd();
            mask.clickUnlockBtn();
            Thread.sleep(3000);
            getDriver().close();
            getDriver().switchTo().window(tabs.get(0));  // switch back to parent window
        }
        System.out.println("Counter value: "+ counter++);
        while(true) { // here you have to check the condition with maximum number of teams which you can get from manage teams page
            getDriver().navigate().refresh();
            crab.waitForMininigExpeditionToBeFinished(); // you have to take this statement out for contnuity of teams
            crab.clickClaimButton();
            Thread.sleep(5000);
            this.confirmMetaMaskTransaction(mask);
            Thread.sleep(5000);
            try {
                this.startMiningExpeditionsWorkflow();
                Thread.sleep(5000);
                this.testReinforceFunctionality();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void confirmMetaMaskTransaction(MetaMaskPage mask) throws InterruptedException {
        Thread.sleep(5000);
        ArrayList<String> windows = new ArrayList<String>(getDriver().getWindowHandles());
        if(windows.size()>1) {
            getDriver().switchTo().window(windows.get(1));
            mask.clickConfirmBtn();
            getDriver().switchTo().window(windows.get(0));  // switch back to parent window
        }

    }

   // @Test
    public void clickConnectWalletLeftMenu() throws InterruptedException, IOException {

        CrabadaPage crab = new CrabadaPage(getDriver());
        Thread.sleep(3000);
        crab.clickConnectWalletLeftMenuButton();
        Thread.sleep(3000);
        getDriver().navigate().refresh();
        Thread.sleep(3000);
        String parentWindowHandler = getDriver().getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = getDriver().getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        getDriver().switchTo().window(subWindowHandler); // switch to popup window

        // Now you are in the popup window, perform necessary actions here
        //WebElement passwordField = getDriver().findElement(By.id("password"));



        MetaMaskPage mask = new MetaMaskPage(getDriver());
        mask.enterPasswd();
        mask.clickUnlockBtn();

        getDriver().switchTo().window(parentWindowHandler);  // switch back to parent window
        getDriver().navigate().refresh();
    }
}
