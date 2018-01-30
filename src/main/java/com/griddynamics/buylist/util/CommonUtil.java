package com.griddynamics.buylist.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CommonUtil {

    public static void waitAndMakeScreenshot(AndroidDriver<AndroidElement> driver) throws IOException, InterruptedException {
        AllureUtils.saveScreenshot(AllureUtils.getScreenshot(driver));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static String getExpectedTotal(String price, String amount) {
        return String.valueOf(Integer.parseInt(price) * Integer.parseInt(amount));
    }
}