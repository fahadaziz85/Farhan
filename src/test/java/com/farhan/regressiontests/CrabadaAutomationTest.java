package com.farhan.regressiontests;

import com.farhan.basetestframework.BaseClass;
import com.farhan.pageobjects.CrabadaPage;
import com.farhan.pageobjects.GoogleHomePage;
import com.farhan.pageobjects.MetaMaskPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class CrabadaAutomationTest extends BaseClass {



    @Test
    public void clickConnectWalletAlert() throws InterruptedException {
        CrabadaPage crab = new CrabadaPage(getDriver());
       // crab.clickConnectWallet();

    }

   // @Test
    public void clickConnectWalletLeftMenu() throws InterruptedException {

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

        mask.clickUnlockBtn();

        getDriver().switchTo().window(parentWindowHandler);  // switch back to parent window
        getDriver().navigate().refresh();
    }
}
