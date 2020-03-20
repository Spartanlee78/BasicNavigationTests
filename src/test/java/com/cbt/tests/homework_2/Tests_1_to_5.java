package com.cbt.tests.homework_2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests_1_to_5 {

    private WebDriver driver;
    private By registrationLink = By.linkText("Registration Form");



    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.createADriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(2000);
        driver.findElement(registrationLink).click();
        BrowserUtils.wait(2000);
    }
    @AfterMethod
    public void endTask(){
        if (!driver.equals(null)){
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void test1(){

        driver.findElement(By.name("birthday")).sendKeys("abcd");
        BrowserUtils.wait(2000);
        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//*[.='The date of birth is not valid']")).getText();
        Assert.assertEquals(expected,actual,"expected: "+ expected +" "+"actual: "+ actual);


    }




}
