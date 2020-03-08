package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                                          "http://practice.cybertekschool.com/dropdown",
                                            "http://practice.cybertekschool.com/login");


        WebDriver chromeDriver = BrowserFactory.createADriver("chrome");

        for (String eachUrl : urls) {

            chromeDriver.navigate().to(eachUrl);
            BrowserUtils.wait(1000);
            if(chromeDriver.getCurrentUrl().startsWith("http://practice.cybertekschool.com")){
                System.out.println("test passed");
            }else {
                System.out.println("test failed");
            }
            BrowserUtils.wait(1000);


        }

        chromeDriver.quit();
        // http://practice.cybertekschool.com/
    }
}
