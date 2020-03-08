package com.cbt.utilities;

public class StringUtility {

    public static void verifyEquals (String expected, String actual){

        if (expected.equals(actual)){
            System.out.println("PASS");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }else {
            System.out.println("FAIl");
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }
}
