package com.farhan.regressiontests;

import com.farhan.basetestframework.BaseClass;
import com.farhan.pageobjects.CrabadaPage;
import com.farhan.pageobjects.GoogleHomePage;
import org.testng.annotations.Test;

public class CrabadaAutomationTest extends BaseClass {



    @Test
    public void clickConnectWalletAlert() throws InterruptedException {
        CrabadaPage crab = new CrabadaPage(getDriver());
        crab.clickConnectWallet();

    }

    @Test
    public void clickConnectWalletLeftMenu() throws InterruptedException {

        CrabadaPage crab = new CrabadaPage(getDriver());
        Thread.sleep(3000);
        crab.clickConnectWalletLeftMenuButton();

    }
}
