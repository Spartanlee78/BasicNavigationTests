package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerfication2 {
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                                        "https://wayfair.com/",
                                        "https://walmart.com" ,
                                        "https://westelm.com/");




        WebDriver driver = BrowserFactory.createADriver("chrome");


       // driver.get();













//        for (String eachUrl : urls) {
//
//            String checked = eachUrl.substring(eachUrl.indexOf("/")+2,eachUrl.indexOf(".com")).toLowerCase();
//            String title = driver.getTitle().toLowerCase();
//
//
//            driver.navigate().to(eachUrl);
//
//            if (title.contains(checked)){
//                System.out.println("test passed");
//            }else {
//                System.out.println("test failed");
//            }
//            BrowserUtils.wait(2000);
//
//        }

        driver.quit();
    }
}
