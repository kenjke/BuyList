package com.griddynamics.buylist;

import com.griddynamics.buylist.enums.*;
import com.griddynamics.buylist.step.CommonStep;
import com.griddynamics.buylist.step.ListStep;
import com.griddynamics.buylist.step.MainActivityStep;
import com.griddynamics.buylist.util.BaseAssertions;
import com.griddynamics.buylist.util.CommonUtil;
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

public class ListTest implements TestConstants {

    private AndroidDriver<AndroidElement> driver;
    private BaseAssertions baseAssertions = new BaseAssertions();

    @BeforeTest(groups = "list")
    public void initialize() {
        driver = Configuration.initialize();
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @AfterTest(groups = "list")
    public void kill() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

    @Test(groups = "list")
    @Title("User enters list name, clicks on \"+\". Check that title is changed.")
    @TestCaseId("1")
    public void createListAndCheckThatTitleIsChanged() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.enterName(ListNames.Apples.toString(), EnterNames.List.toString());

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();

        ListStep listStep = new ListStep(driver);
        baseAssertions.checkEqual(listStep.getTopicName(), ListNames.Apples.toString(),
                Steps.TopicName.toString() + ListNames.Apples.toString());
    }

    @Test(groups = "list")
    @Title("User enters list name, clicks on \"+\", adds 1 product. Check that total price is changed.")
    @TestCaseId("2")
    public void createListAndCheckThatTotalIsChanged() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.enterName(ListNames.Apples.toString(), EnterNames.List.toString());

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();

        ListStep listStep = new ListStep(driver);
        baseAssertions.checkEqual(listStep.getTopicName(), ListNames.Apples.toString(),
                Steps.TopicName.toString() + ListNames.Apples.toString());
        listStep.enterProductName(PRODUCT_NAME);
        listStep.enterPrice(PRICE);
        listStep.enterAmount(AMOUNT);
        commonStep.takeOptionFromSpinner(SpinnerNames.Measure.toString(), Measures.Bottles.toString());
        listStep.enterComment(PRODUCT_NAME);
        commonStep.takeOptionFromSpinner(SpinnerNames.Category.toString(), Categories.PetProducts.toString());
        commonStep.clickAddButton();

        String expectedAmount = CommonUtil.getExpectedTotal(PRICE, AMOUNT);
        baseAssertions.checkEqual(listStep.getTotal(), expectedAmount, Steps.Total.toString() + expectedAmount);
    }

    @Test(groups = "list")
    @Title("User can create two lists with similar names.")
    @TestCaseId("3")
    public void createListsWithSimilarNames() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.enterName(ListNames.ForDinner.toString(), EnterNames.List.toString());
        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();
        driver.hideKeyboard();
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), ListNames.ForDinner.toString())).size()),
                Sizes.One.toString(), Steps.Size.toString() + Sizes.One.toString());

        commonStep.enterName(ListNames.ForDinner.toString(), EnterNames.List.toString());
        mainActivityStep.clickAddButton();
        driver.hideKeyboard();
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), ListNames.ForDinner.toString())).size()),
                Sizes.Two.toString(), Steps.Size.toString() + Sizes.Two.toString());
    }

    @Test(groups = "list")
    @Title("User can change list's name.")
    @TestCaseId("4")
    public void createListAndChangeTitle() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.enterName(ListNames.Apples.toString(), EnterNames.List.toString());
        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();
        driver.hideKeyboard();
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), ListNames.Apples.toString())).size()),
                Sizes.One.toString(), Steps.Size.toString() + Sizes.One.toString());

        mainActivityStep.clickChangeButton();
        mainActivityStep.changeListName(ListNames.Apples.toString(), ListNames.Bottles.toString());
        commonStep.clickOKButton();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), ListNames.Bottles.toString())).size()),
                Sizes.One.toString(), Steps.Size.toString() + Sizes.One.toString());
    }

    @Test(groups = "list")
    @Title("User can delete list.")
    @TestCaseId("5")
    public void createListAndDeleteIt() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.enterName(ListNames.Wishes.toString(), EnterNames.List.toString());
        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();
        driver.hideKeyboard();
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), ListNames.Wishes.toString())).size()),
                Sizes.One.toString(), Steps.Size.toString() + Sizes.One.toString());

        mainActivityStep.clickDeleteButton();
        mainActivityStep.clickOKButtonByDriver();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator(
                        String.format(Locators.TextUiAutomator.toString(), ListNames.Wishes.toString())).size()),
                Sizes.Zero.toString(), Steps.Size.toString() + Sizes.Zero.toString());
    }
}