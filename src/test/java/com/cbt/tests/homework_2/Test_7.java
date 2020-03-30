package com.cbt.tests.homework_2;


import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.PracticeCyberHomeTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test_7 extends PracticeCyberHomeTestBase {



    @Test
    public void test7(){

        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtils.waitForPageToLoad(10);
      //  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("File Upload"))).

        String txtDocPath = "C:\\Users\\Sang Lee\\IdeaProjects\\BasicNavigationTests\\src\\test\\java\\com\\cbt\\tests\\homework_2\\homework7.txt";
        WebElement chooseFileBtn = driver.findElement(By.id("file-upload"));
        chooseFileBtn.sendKeys(txtDocPath);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.waitForPageToLoad(10);
        WebElement fileUpload = driver.findElement(  By.xpath("//*[.='File Uploaded!']"));
        wait.until(ExpectedConditions.visibilityOf(fileUpload));
        Assert.assertEquals(fileUpload.getText(),"File Uploaded!");
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(),"homework7.txt");


    }



}
