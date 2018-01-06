package com.griddynamics.buylist;

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
        commonStep.enterName(LIST_NAMES.get(0), ENTER_NAME.get(0));

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();

        ListStep listStep = new ListStep(driver);
        baseAssertions.checkEqual(listStep.getTopicName(), LIST_NAMES.get(0), TOPIC_NAME_STEP + LIST_NAMES.get(0));
    }

    @Test(groups = "list")
    @Title("User enters list name, clicks on \"+\", adds 1 product. Check that total price is changed.")
    @TestCaseId("2")
    public void createListAndCheckThatTotalIsChanged() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.enterName(LIST_NAMES.get(0), ENTER_NAME.get(0));

        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();

        ListStep listStep = new ListStep(driver);
        baseAssertions.checkEqual(listStep.getTopicName(), LIST_NAMES.get(0), TOPIC_NAME_STEP + LIST_NAMES.get(0));
        listStep.enterProductName(PRODUCT_NAME);
        listStep.enterPrice(PRICE);
        listStep.enterAmount(AMOUNT);
        commonStep.takeOptionFromSpinner(SPINNER_NAMES.get(0), MEASURES_LIST.get(0));
        listStep.enterComment(PRODUCT_NAME);
        commonStep.takeOptionFromSpinner(SPINNER_NAMES.get(1), CATEGORY_LIST.get(0));
        commonStep.clickAddButton();

        String expectedAmount = CommonUtil.getExpectedTotal(PRICE, AMOUNT);
        baseAssertions.checkEqual(listStep.getTotal(), expectedAmount, TOTAL_STEP + expectedAmount);
    }

    @Test(groups = "list")
    @Title("User can create two lists with similar names.")
    @TestCaseId("3")
    public void createListsWithSimilarNames() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.enterName(LIST_NAMES.get(3), ENTER_NAME.get(0));
        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();
        driver.hideKeyboard();
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + LIST_NAMES.get(3) + "\")").size()),
                SIZES.get(1), SIZE_STEP + SIZES.get(1));

        commonStep.enterName(LIST_NAMES.get(3), ENTER_NAME.get(0));
        mainActivityStep.clickAddButton();
        driver.hideKeyboard();
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + LIST_NAMES.get(3) + "\")").size()),
                SIZES.get(2), SIZE_STEP + SIZES.get(2));
    }

    @Test(groups = "list")
    @Title("User can change list's name.")
    @TestCaseId("4")
    public void createListAndChangeTitle() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.enterName(LIST_NAMES.get(0), ENTER_NAME.get(0));
        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();
        driver.hideKeyboard();
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + LIST_NAMES.get(0) + "\")").size()),
                SIZES.get(1), SIZE_STEP + SIZES.get(1));

        mainActivityStep.clickChangeButton();
        mainActivityStep.changeListName(LIST_NAMES.get(0), LIST_NAMES.get(1));
        commonStep.clickOKButton();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + LIST_NAMES.get(1) + "\")").size()),
                SIZES.get(1), SIZE_STEP + SIZES.get(1));
    }

    @Test(groups = "list")
    @Title("User can delete list.")
    @TestCaseId("5")
    public void createListAndDeleteIt() throws IOException, InterruptedException {
        CommonStep commonStep = new CommonStep(driver);
        commonStep.enterName(LIST_NAMES.get(2), ENTER_NAME.get(0));
        MainActivityStep mainActivityStep = new MainActivityStep(driver);
        mainActivityStep.clickAddButton();
        driver.hideKeyboard();
        driver.navigate().back();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + LIST_NAMES.get(2) + "\")").size()),
                SIZES.get(1), SIZE_STEP + SIZES.get(1));

        mainActivityStep.clickDeleteButton();
        mainActivityStep.clickOKButtonByDriver();
        baseAssertions.checkEqual(String.valueOf(driver.findElementsByAndroidUIAutomator("text(\"" + LIST_NAMES.get(2) + "\")").size()),
                SIZES.get(0), SIZE_STEP + SIZES.get(0));
    }
}