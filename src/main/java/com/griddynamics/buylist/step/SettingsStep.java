package com.griddynamics.buylist.step;

import com.griddynamics.buylist.util.CommonUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.internal.Coordinates;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.List;

public class SettingsStep {

    private AndroidDriver<AndroidElement> driver;

    public SettingsStep(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    @Step("Choose option by coordinates.")
    public AndroidElement chooseOptionByCoordinates(Point start, String className, boolean isClickable) throws IOException, InterruptedException {
        List<AndroidElement> elements = driver.findElements(By.className(className));
        AndroidElement toReturn = null;
        for (AndroidElement element : elements) {
            Coordinates coordinates = element.getCoordinates();
            if (coordinates.onPage().getX() == start.getX() && coordinates.onPage().getY() == start.getY()) {
                toReturn = element;
                if (isClickable) {
                    element.click();
                }
                break;
            }
        }
        CommonUtil.waitAndMakeScreenshot(driver);
        return toReturn;
    }

    @Step("Scrolling to needful option.")
    public void scroll(String name) throws IOException, InterruptedException {
        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + name + "\"))");
        CommonUtil.waitAndMakeScreenshot(driver);
    }

    @Step("Get information whether option is checked or not")
    public String getIsChecked(Point point, String className) throws IOException, InterruptedException {
        return chooseOptionByCoordinates(point, className, false).getAttribute("checked");
    }
}