package com.griddynamics.buylist.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;

public class CommonUtil {

    public static void waitAndMakeScreenshot(AndroidDriver<AndroidElement> driver) throws IOException, InterruptedException {
        Thread.sleep(20000);
        AllureUtils.saveScreenshot(AllureUtils.getScreenshot(driver));
    }

    public static String getExpectedTotal(String price, String amount) {
        return String.valueOf(Integer.parseInt(price) * Integer.parseInt(amount));
    }
}