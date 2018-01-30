package com.griddynamics.buylist;

import com.griddynamics.buylist.enums.*;
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
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), SortList.ByCategory.toString())).size()),
                Sizes.One.toString(), Steps.Size.toString() + Sizes.One.toString());

        SettingsStep settingsStep = new SettingsStep(driver);
        settingsStep.clickOnLinearLayout(1, SpinnerNames.SortList.toString());
        commonStep.takeOptionFromSpinner(SpinnerNames.SortList.toString(), SortList.ByAlphabet.toString());
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), SortList.ByCategory.toString())).size()),
                Sizes.Zero.toString(), Steps.Size.toString() + Sizes.Zero.toString());
    }

    @Test(groups = "settings")
    @Title("User can edit \"Currency\" from \"Settings\".")
    @TestCaseId("7")
    public void changeCurrency() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.clickSettingsButton();

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.choosePointFromSettings(0);
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), Currencies.Funt.toString())).size()),
                Sizes.One.toString(), Steps.Size.toString() + Sizes.One.toString());

        SettingsStep settingsStep = new SettingsStep(driver);
        settingsStep.clickOnLinearLayout(2, SpinnerNames.Currency.toString());
        commonStep.takeOptionFromSpinner(SpinnerNames.Currency.toString(), SortList.ByAlphabet.toString());
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), Currencies.Funt.toString())).size()),
                Sizes.Zero.toString(), Steps.Size.toString() + Sizes.Zero.toString());
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
        settingsStep.clickOnLinearLayout(9, SpinnerNames.Category.toString());

        commonStep.clickAddButton();
        commonStep.enterName(Categories.Fencing.toString(), EnterNames.Category.toString());
        commonStep.clickOKButton();
        settingsStep.scroll(Categories.Fencing.toString());
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), Categories.Fencing.toString())).size()),
                Sizes.One.toString(), Steps.Size.toString() + Sizes.One.toString());
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
        baseAssertions.checkEqual(settingsStep.getIsChecked(), TRUE_VALUE, Steps.Checked.toString());
        settingsStep.clickOnPrice();
        baseAssertions.checkEqual(settingsStep.getIsChecked(), FALSE_VALUE, Steps.Unchecked.toString());
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
        baseAssertions.checkEqual(listStep.getTopicName(), DEFAULT_LIST, Steps.TopicName.toString() + DEFAULT_LIST);
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), DEFAULT_LIST)).size()),
                Sizes.Zero.toString(), Steps.Size.toString() + Sizes.Zero.toString());
    }
}