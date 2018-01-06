package com.griddynamics.buylist.client;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainActivityClient {

    @AndroidFindBy(id = "com.slava.buylist:id/button2")
    WebElement addListButton;

    @AndroidFindBy(id = "com.slava.buylist:id/imageView2")
    WebElement changeButton;

    @AndroidFindBy(id = "com.slava.buylist:id/imageView1")
    WebElement deleteButton;

    public MainActivityClient(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement getAddListButton() {
        return addListButton;
    }

    public void setAddListButton(WebElement addListButton) {
        this.addListButton = addListButton;
    }

    public WebElement getChangeButton() {
        return changeButton;
    }

    public void setChangeButton(WebElement changeButton) {
        this.changeButton = changeButton;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(WebElement deleteButton) {
        this.deleteButton = deleteButton;
    }
}