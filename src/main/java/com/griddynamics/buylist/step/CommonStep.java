package com.griddynamics.buylist.step;

import com.griddynamics.buylist.client.CommonClient;
import com.griddynamics.buylist.client.ListClient;
import com.griddynamics.buylist.util.CommonUtil;
import com.griddynamics.buylist.util.TestConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

public class CommonStep implements TestConstants {

    private AndroidDriver<AndroidElement> driver;
    private CommonClient commonClient;

    public CommonStep(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        commonClient = new CommonClient(driver);
    }

    @Step("Click on \"Add\".")
    public void clickAddButton() throws IOException, InterruptedException {
        commonClient.getAddButton().click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Enter name of {1}.")
    public void enterName(String name, String option) throws IOException, InterruptedException {
        commonClient.getEditText().sendKeys(name);
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Click on \"OK\".")
    public void clickOKButton() throws IOException, InterruptedException {
        commonClient.getOkButton().click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Click on \"Settings\".")
    public void clickSettingsButton() throws IOException, InterruptedException {
        commonClient.getSettingsButton().click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Enter {0}.")
    public void takeOptionFromSpinner(String spinnerName, String name) throws IOException, InterruptedException {
        if (spinnerName.equals(SPINNER_NAMES.get(0))) {
            ListClient listClient = new ListClient(driver);
            listClient.getMeasures().click();
        } else if (spinnerName.equals(SPINNER_NAMES.get(1))) {
            ListClient listClient = new ListClient(driver);
            listClient.getCategories().click();
        }
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + name + "']")).click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }
}