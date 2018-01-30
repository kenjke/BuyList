package com.griddynamics.buylist.step;

import com.griddynamics.buylist.enums.Locators;
import com.griddynamics.buylist.util.CommonUtil;
import com.griddynamics.buylist.util.TestConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

public class SettingsStep implements TestConstants {

    private AndroidDriver<AndroidElement> driver;

    public SettingsStep(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    @Step("Scrolling to needful option.")
    public void scroll(String name) throws IOException, InterruptedException {
        driver.findElementsByAndroidUIAutomator(String.format(Locators.Scroll.toString(), name));
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Click on {1}.")
    public void clickOnLinearLayout(int layoutNumber, String item) throws IOException, InterruptedException {
        driver.findElementByXPath(String.format(Locators.HierarchyXpath.toString(), layoutNumber)).click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Get information whether option is checked or not")
    public String getIsChecked() throws IOException, InterruptedException {
        return driver.findElementByXPath(Locators.PriceCheckBoxXpath.toString()).getAttribute(CHECKED_VALUE);
    }

    @Step("Click on Price.")
    public void clickOnPrice() throws IOException, InterruptedException {
        driver.findElementByXPath(Locators.PriceCheckBoxXpath.toString()).click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }
}