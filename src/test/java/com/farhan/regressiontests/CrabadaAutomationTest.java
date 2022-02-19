package com.farhan.regressiontests;

import com.farhan.basetestframework.BaseClass;
import com.farhan.pageobjects.CrabadaPage;
import com.farhan.pageobjects.GoogleHomePage;
import org.testng.annotations.Test;

public class CrabadaAutomationTest extends BaseClass {

    @Test
    public void TestClaimReward() {
        CrabadaPage crab = new CrabadaPage(getDriver());
        crab.clickConnectWallet();

    }
}
