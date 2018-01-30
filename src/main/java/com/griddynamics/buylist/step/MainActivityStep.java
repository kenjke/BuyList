package com.griddynamics.buylist.step;

import com.griddynamics.buylist.client.MainActivityClient;
import com.griddynamics.buylist.enums.Locators;
import com.griddynamics.buylist.util.CommonUtil;
import com.griddynamics.buylist.util.TestConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.List;

public class MainActivityStep implements TestConstants {

    private AndroidDriver<AndroidElement> driver;
    private MainActivityClient mainActivityClient;

    public MainActivityStep(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        mainActivityClient = new MainActivityClient(driver);
    }

    @Step("Click on \"+\".")
    public void clickAddButton() throws IOException, InterruptedException {
        mainActivityClient.getAddListButton().click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Click on \"Change\".")
    public void clickChangeButton() throws IOException, InterruptedException {
        mainActivityClient.getChangeButton().click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Change name of the list from {0} to {1}.")
    public void changeListName(String oldName, String newName) throws IOException, InterruptedException {
        WebElement editText = driver.findElementByClassName(Locators.EditTextClass.toString());
        editText.clear();
        editText.sendKeys(newName);
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Click on \"OK\".")
    public void clickOKButtonByDriver() throws IOException, InterruptedException {
        WebElement item = driver.findElementById(Locators.ButtonPanelId.toString());
        item.findElement(By.id(Locators.Button1Id.toString())).click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Click on \"Delete\".")
    public void clickDeleteButton() throws IOException, InterruptedException {
        WebElement item = driver.findElementById(Locators.Rr1Id.toString());
        item.findElement(By.id(Locators.ImageView1Id.toString())).click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Choose point from \"Settings\" menu.")
    public void choosePointFromSettings(int index) throws IOException, InterruptedException {
        List<AndroidElement> textViews = driver.findElements(By.className(Locators.LinearLayoutClass.toString()));
        textViews.get(index).click();
        CommonUtil.waitAndMakeScreenshot(driver);
    }
}