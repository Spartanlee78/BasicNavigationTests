package com.cbt.utilities;

public class BrowserUtils {

    public static void wait (int miliSeconds){

        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

