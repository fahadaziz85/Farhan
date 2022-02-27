package com.farhan.pageobjects;

import com.farhan.basetestframework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
    public int getMaxiumTeamSize() throws IOException {
        Properties prop = new Properties();
        FileInputStream loadFile = new FileInputStream("C:\\Users\\fbash\\IdeaProjects\\Farhan\\Config.properties");
        prop.load(loadFile);
        return Integer.parseInt(prop.getProperty("maxTeamSize"));
    }



}
