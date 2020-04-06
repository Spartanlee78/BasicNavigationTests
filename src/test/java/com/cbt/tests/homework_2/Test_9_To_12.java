package com.cbt.tests.homework_2;

import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.ConfigurationReader;
import com.cbt.utilities.Driver;
import com.cbt.utilities.PracticeCyberHomeTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_9_To_12 {


     WebDriver driver;
     WebDriverWait wait;
     Actions actions;

    @BeforeMethod
    public void setup(){

        String url = ConfigurationReader.getProperty("practiceCyberURL");
        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(),15);
        actions = new Actions(Driver.getDriver());
        BrowserUtils.waitForPageToLoad(5);
    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();

    }

    @DataProvider
    public Object[][] testNineToTwelveData() {
        return new Object[][]{
                {"200","This page returned a 200 status code"},
                {"301","This page returned a 301 status code"},
                {"404","This page returned a 404 status code"},
                {"500","This page returned a 500 status code"}
        };
    }


    @Test(dataProvider = "testNineToTwelveData")
    public void testNineToTwelve(String linktxt, String expectedMsg){
        Driver.getDriver();
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.waitForPageToLoad(10);

        WebElement linkNum = driver.findElement(By.linkText(linktxt));
        linkNum.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p"))));
        WebElement target = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(target.getText().contains("This page returned a "+linktxt+" status code"));

    }

}
