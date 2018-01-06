package com.griddynamics.buylist.client;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CommonClient {

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    WebElement addButton;

    @AndroidFindBy(className = "android.widget.EditText")
    WebElement editText;

    @AndroidFindBy(uiAutomator = "text(\"OK\")")
    WebElement okButton;

    @AndroidFindBy(id = "com.slava.buylist:id/button1")
    WebElement settingsButton;

    public CommonClient(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement getAddButton() {
        return addButton;
    }

    public void setAddButton(WebElement addButton) {
        this.addButton = addButton;
    }

    public WebElement getEditText() {
        return editText;
    }

    public void setEditText(WebElement editText) {
        this.editText = editText;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public void setOkButton(WebElement okButton) {
        this.okButton = okButton;
    }

    public WebElement getSettingsButton() {
        return settingsButton;
    }

    public void setSettingsButton(WebElement settingsButton) {
        this.settingsButton = settingsButton;
    }
}