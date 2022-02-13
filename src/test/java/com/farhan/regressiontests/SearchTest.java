package com.farhan.regressiontests;

import com.farhan.basetestframework.BaseClass;
import com.farhan.pageobjects.GoogleHomePage;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass {
    @Test
    public void TestCase2() {

        GoogleHomePage google = new GoogleHomePage(getDriver());
        google.acceptCookies();
        google.searchText("cheese");


    }
}
