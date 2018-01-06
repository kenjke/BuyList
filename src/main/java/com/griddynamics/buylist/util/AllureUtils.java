package com.griddynamics.buylist.util;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.IOException;
import java.nio.file.Files;

public class AllureUtils {

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String attachName, String message) {
        return message;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    public static byte[] getScreenshot(AndroidDriver driver) throws IOException {
        return Files.readAllBytes(driver.getScreenshotAs(OutputType.FILE).toPath());
    }
}