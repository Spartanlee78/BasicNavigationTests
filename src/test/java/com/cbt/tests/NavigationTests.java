package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {

       WebDriver chromeDriver = BrowserFactory.createADriver("chrome");
       chromeDriver.get("https://google.com");
       String title1 = chromeDriver.getTitle();
       chromeDriver.navigate().to("https://etsy.com");
       String title2 = chromeDriver.getTitle();
       chromeDriver.navigate().back();

        StringUtility.verifyEquals(chromeDriver.getTitle(),title1);

        chromeDriver.navigate().forward();

        StringUtility.verifyEquals(chromeDriver.getTitle(),title2);


        chromeDriver.quit();


    }


}
