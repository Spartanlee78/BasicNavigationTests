package com.cbt.tests.homework_2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Tests_1_to_5 {

    private WebDriver driver;
    private By registrationLink = By.linkText("Registration Form");



    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.createADriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(registrationLink).click();

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

        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//*[.='The date of birth is not valid']")).getText();
        Assert.assertEquals(expected,actual,"expected: "+ expected +"\n"+"actual: "+ actual);
    }

    @Test
    public void test2 (){
        String expJava = "Java";
        String actJava = driver.findElement(By.xpath("//*[.='Java']")).getText();
        String expCPlusPlus = "C++";
        String adtCPlusPlus = driver.findElement(By.xpath("//*[.='C++']")).getText();
        String expJScript = "JavaScript";
        String actJScript = driver.findElement(By.xpath("//*[.='JavaScript']")).getText();

        List<String> expected = Arrays.asList( expJava,expCPlusPlus,expJScript);
        List<String> actual = Arrays.asList(actJava,adtCPlusPlus,actJScript);

        Assert.assertEquals(expected,actual,"expected: "+ expected +"\n"+"actual: "+ actual);
    }

    @Test
    public void test3(){
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("a");
        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//*[.='first name must be more than " +
                                            "2 and less than 64 characters long']")).getText();

        Assert.assertEquals(expected,actual,"expected: "+ expected +"\n"+"actual: "+ actual);
    }

    @Test
    public void test4(){
        driver.findElement(By.name("lastname")).sendKeys("a");
        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(By.xpath("//*[.='The last name must be more than 2 and " +
                "less than 64 characters long']")).getText();
        Assert.assertEquals(expected,actual,"expected: "+ expected +"\n"+"actual: "+ actual);
    }

    @Test
    public void test5(){

        Select departmentSelect = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        Select jobTitleSelect = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));

        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Evelyn");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Lee");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("YeEunLee");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("evie2020@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("MiraSang");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("713-000-0000");
        driver.findElement(By.xpath("//input[@type='radio'][@value='female']")).click();
        driver.findElement(By.name("birthday")).sendKeys("07/07/2019");
        departmentSelect.selectByValue("MO");
        jobTitleSelect.selectByVisibleText("Product Owner");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.xpath("//h4/following-sibling::*[1]")).getText();

        Assert.assertEquals(expected,actual,"expected: "+ expected +"\n"+"actual: "+ actual);

    }




}
