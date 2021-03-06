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

        driver.get("https://www.google.com/");
        BrowserUtils.wait(1000);

        for (String eachUrl : urls) {

            String checked = eachUrl.substring(eachUrl.indexOf("/")+2,eachUrl.indexOf(".com")).toLowerCase();

            driver.navigate().to(eachUrl);
            BrowserUtils.wait(1000);
            String title = driver.getTitle().toLowerCase().replaceAll(" ","");

            if (title.contains(checked)){
                System.out.println("test passed");
                System.out.println("URL title:     " + checked);
                System.out.println("Website Title: " + title);
                System.out.println();
            }else {
                System.out.println("test failed");
                System.out.println("URL title:     " + checked);
                System.out.println("Website Title: " + title);
                System.out.println();
            }

            BrowserUtils.wait(1000);

        }

        driver.quit();
    }
}
