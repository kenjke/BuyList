package com.griddynamics.buylist.step;

import com.google.common.base.CharMatcher;
import com.griddynamics.buylist.client.ListClient;
import com.griddynamics.buylist.util.CommonUtil;
import com.griddynamics.buylist.util.TestConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

public class ListStep implements TestConstants {

    private AndroidDriver<AndroidElement> driver;
    private ListClient listClient;

    public ListStep(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        listClient = new ListClient(driver);
    }

    @Step("Get topic name.")
    public String getTopicName() throws IOException {
        return listClient.getTopic().getText();
    }

    @Step("Enter product name.")
    public void enterProductName(String name) throws IOException, InterruptedException {
        listClient.getAddProductList().sendKeys(name);
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Enter price.")
    public void enterPrice(String name) throws IOException, InterruptedException {
        listClient.getPrice().sendKeys(name);
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Enter amount.")
    public void enterAmount(String name) throws IOException, InterruptedException {
        listClient.getAmount().sendKeys(name);
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Enter comment.")
    public void enterComment(String name) throws IOException, InterruptedException {
        listClient.getComment().sendKeys(name);
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Get total.")
    public String getTotal() throws IOException {
        return CharMatcher.DIGIT.retainFrom(listClient.getTotal().getText());
    }
}