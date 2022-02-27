package com.farhan.pageobjects;

import com.farhan.basetestframework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageTeamsPage extends BasePage {
    // Constructor
    public ManageTeamsPage(WebDriver driver) {
        super(driver);
    }

    // UI Elements / Locators

    @FindBy(tagName = "h3")
    private WebElement maximumTeamSize;



    public String getMaximumTeamSize(){

        maximumTeamSize = maximumTeamSize.findElement(By.tagName("span"));
        return (maximumTeamSize.getAttribute("innerHTML"));
    }



}
