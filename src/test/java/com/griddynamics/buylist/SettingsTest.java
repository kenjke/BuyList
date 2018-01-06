package com.griddynamics.buylist;

import com.griddynamics.buylist.step.CommonStep;
import com.griddynamics.buylist.step.ListStep;
import com.griddynamics.buylist.step.MainActivityStep;
import com.griddynamics.buylist.step.SettingsStep;
import com.griddynamics.buylist.util.BaseAssertions;
import com.griddynamics.buylist.util.TestConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SettingsTest implements TestConstants {

    private AndroidDriver<AndroidElement> driver;
    private BaseAssertions baseAssertions = new BaseAssertions();

    @BeforeTest(groups = "settings")
    public void initialize() {
        driver = Configuration.initialize();
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @AfterTest(groups = "settings")
    public void kill() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test(groups = "settings")
    @Title("User can edit \"Sort List\" from \"Settings\".")
    @TestCaseId("6")
    public void changeCategory() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.clickSettingsButton();

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.choosePointFromSettings(0);
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + SORT_LIST.get(0) + "\")").size()),
                SIZES.get(1), SIZE_STEP + SIZES.get(1));

        SettingsStep settingsStep = new SettingsStep(driver);
        settingsStep.chooseOptionByCoordinates(SORT_LIST_POINT, LINEAR_LAYOUT_WIDGET, true);
        commonStep.takeOptionFromSpinner(SPINNER_NAMES.get(2), SORT_LIST.get(1));
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + SORT_LIST.get(0) + "\")").size()),
                SIZES.get(0), SIZE_STEP + SIZES.get(0));
    }

    @Test(groups = "settings")
    @Title("User can edit \"Currency\" from \"Settings\".")
    @TestCaseId("7")
    public void changeCurrency() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.clickSettingsButton();

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.choosePointFromSettings(0);
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + CURRENCY_LIST.get(0) + "\")").size()),
                SIZES.get(1), SIZE_STEP + SIZES.get(1));

        SettingsStep settingsStep = new SettingsStep(driver);
        settingsStep.chooseOptionByCoordinates(CURRENCY_POINT, LINEAR_LAYOUT_WIDGET, true);
        commonStep.takeOptionFromSpinner(SPINNER_NAMES.get(3), SORT_LIST.get(1));
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + CURRENCY_LIST.get(0) + "\")").size()),
                SIZES.get(0), SIZE_STEP + SIZES.get(0));
    }

    @Test(groups = "settings")
    @Title("User can add new category to \"Categories List\".")
    @TestCaseId("8")
    public void addNewCategory() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.clickSettingsButton();

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.choosePointFromSettings(0);

        SettingsStep settingsStep = new SettingsStep(driver);
        settingsStep.scroll(CATEGORIES_LIST_TEXT_VIEW);
        settingsStep.chooseOptionByCoordinates(CATEGORIES_LIST_POINT, LINEAR_LAYOUT_WIDGET, true);

        commonStep.clickAddButton();
        commonStep.enterName(CATEGORY_LIST.get(1), ENTER_NAME.get(1));
        commonStep.clickOKButton();
        settingsStep.scroll(CATEGORY_LIST.get(1));
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + CATEGORY_LIST.get(1) + "\")").size()),
                SIZES.get(1), SIZE_STEP + SIZES.get(1));
    }

    @Test(groups = "settings")
    @Title("User can uncheck \"Price\".")
    @TestCaseId("9")
    public void uncheckPrice() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.clickSettingsButton();

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.choosePointFromSettings(0);

        SettingsStep settingsStep = new SettingsStep(driver);
        baseAssertions.checkEqual(settingsStep.getIsChecked(PRICE_POINT, CHECKBOX_WIDGET), TRUE_VALUE, CHECKED_OPTION_STEP);
        settingsStep.chooseOptionByCoordinates(PRICE_POINT, CHECKBOX_WIDGET, true);
        baseAssertions.checkEqual(settingsStep.getIsChecked(PRICE_POINT, CHECKBOX_WIDGET), FALSE_VALUE, UNCHECKED_OPTION_STEP);
    }

    @Test(groups = "settings")
    @Title("User can click on \"My List\" and navigate back.")
    @TestCaseId("10")
    public void clickOnMyListAndNavigateBack() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.clickSettingsButton();

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.choosePointFromSettings(1);

        ListStep listStep = new ListStep(driver);
        baseAssertions.checkEqual(listStep.getTopicName(), DEFAULT_LIST, TOPIC_NAME_STEP + DEFAULT_LIST);
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + DEFAULT_LIST + "\")").size()),
                SIZES.get(0), SIZE_STEP + SIZES.get(0));
    }
}