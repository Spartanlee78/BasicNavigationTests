package com.cbt.tests.homework_2;

import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.PracticeCyberHomeTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_8 extends PracticeCyberHomeTestBase {

    @Test
    public void Test8(){

        driver.findElement(By.linkText("Autocomplete")).click();
        BrowserUtils.waitForPageToLoad(10);

        WebElement fillInSpace = driver.findElement(By.id("myCountry"));
        fillInSpace.sendKeys("United States of America");

        WebElement verifynote = driver.findElement(By.xpath("//*[@id='myCountryautocomplete-list']//strong"));
        wait.until(ExpectedConditions.visibilityOf(verifynote));

        Assert.assertEquals(verifynote.getText(),"United States of America");
    }

}
