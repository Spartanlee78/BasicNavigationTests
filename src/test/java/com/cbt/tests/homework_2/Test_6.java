package com.cbt.tests.homework_2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.print.DocFlavor;
import java.util.concurrent.TimeUnit;

public class Test_6 {

    private WebDriver driver;
    private String tempMailUrl = "abdulhadi.sharon@aallaa.org";

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.createADriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }
    @AfterMethod
    public void endTask(){
        if (!driver.equals(null)){
            driver.quit();
            driver = null;
        }
    }

    @Test
    public void test6 (){
        String tempMailUrl = driver.findElement(By.id("email")).getText();
        System.out.println(tempMailUrl);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.xpath("//input[1]")).sendKeys("Evelyn Lee");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(tempMailUrl);
        driver.findElement(By.xpath("//button[@name='wooden_spoon']")).click();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.xpath("//h3[@name='signup_message']")).getText();
        Assert.assertEquals(expected,actual);

        driver.navigate().to("https://www.tempmailaddress.com/");

        String emailReceived = "Thanks for subscribing to practice.cybertekschool.com!";
        WebElement emailReceivedfromcyber = driver.findElement(By.xpath
                ("//tbody[@id='schranka']//td[contains(text(),'Thanks for subscribing to practice.cybertekschool.com!')]"));
        String emailActual = emailReceivedfromcyber.getText();

        Assert.assertEquals(emailReceived,emailActual);
        emailReceivedfromcyber.click();

        String expectedEmailFrom = "do-not-reply@practice.cybertekschool.com";
        String actualEmailFrom = driver.findElement(By.id("odesilatel")).getText();
        Assert.assertEquals(expectedEmailFrom,actualEmailFrom);

        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.id("predmet")).getText();

        Assert.assertEquals(expectedSubject,actualSubject);

    }

}
