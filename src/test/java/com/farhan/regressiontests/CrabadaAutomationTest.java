package com.farhan.regressiontests;

import com.farhan.basetestframework.BaseClass;
import com.farhan.pageobjects.CrabadaPage;
import com.farhan.pageobjects.MetaMaskPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.io.IOException;
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
        }
        System.out.println("Counter value: "+ counter++);
        getDriver().navigate().refresh();
        crab.clickDashboard();
        Thread.sleep(3000);
        crab.clickMiningExpedition();
        Thread.sleep(5000);
        crab.clickStartMiningExpeditionsBtn();
        Thread.sleep(5000);
        crab.clickSelectBtn();
        this.confirmMetaMaskTransaction(mask);


    }

    @Test(priority = 2)
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
        while(true) {
            getDriver().navigate().refresh();
            crab.waitForMininigExpeditionToBeFinished();
            crab.clickClaimButton();
            Thread.sleep(5000);
            this.confirmMetaMaskTransaction(mask);
            Thread.sleep(5000);
            try {
                this.startMiningExpeditionsWorkflow();
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
