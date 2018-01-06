package com.griddynamics.buylist;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class Configuration {

    public static AndroidDriver<AndroidElement> initialize() {
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, properties.getProperty("device.name"));
            capabilities.setCapability(MobileCapabilityType.APP, new File(properties.getProperty("path.to.app")));
            return new AndroidDriver<>(new URL(properties.getProperty("appium.uri")), capabilities);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}