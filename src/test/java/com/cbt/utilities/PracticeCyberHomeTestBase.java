package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class PracticeCyberHomeTestBase {

    public WebDriver driver = Driver.getDriver();

    public WebDriverWait wait;
    public Actions actions;




    @BeforeMethod
    public void setup(){

        String url = ConfigurationReader.getProperty("practiceCyberURL");
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(),15);
        actions = new Actions(Driver.getDriver());
        BrowserUtils.waitForPageToLoad(5);
    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
        BrowserUtils.wait(2000);
    }
}
