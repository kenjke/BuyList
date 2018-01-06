package com.griddynamics.buylist.client;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ListClient {

    @AndroidFindBy(id = "com.slava.buylist:id/textView1")
    WebElement topic;

    @AndroidFindBy(id = "com.slava.buylist:id/textView2")
    WebElement total;

    @AndroidFindBy(id = "com.slava.buylist:id/editText1")
    WebElement addProductList;

    @AndroidFindBy(id = "com.slava.buylist:id/editText2")
    WebElement price;

    @AndroidFindBy(id = "com.slava.buylist:id/editText3")
    WebElement amount;

    @AndroidFindBy(id = "com.slava.buylist:id/editText4")
    WebElement comment;

    @AndroidFindBy(id = "com.slava.buylist:id/spinner1")
    WebElement measures;

    @AndroidFindBy(id = "com.slava.buylist:id/spinner2")
    WebElement categories;

    public ListClient(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement getTopic() {
        return topic;
    }

    public void setTopic(WebElement topic) {
        this.topic = topic;
    }

    public WebElement getTotal() {
        return total;
    }

    public void setTotal(WebElement total) {
        this.total = total;
    }

    public WebElement getAddProductList() {
        return addProductList;
    }

    public void setAddProductList(WebElement addProductList) {
        this.addProductList = addProductList;
    }

    public WebElement getPrice() {
        return price;
    }

    public void setPrice(WebElement price) {
        this.price = price;
    }

    public WebElement getAmount() {
        return amount;
    }

    public void setAmount(WebElement amount) {
        this.amount = amount;
    }

    public WebElement getComment() {
        return comment;
    }

    public void setComment(WebElement comment) {
        this.comment = comment;
    }

    public WebElement getMeasures() {
        return measures;
    }

    public void setMeasures(WebElement measures) {
        this.measures = measures;
    }

    public WebElement getCategories() {
        return categories;
    }

    public void setCategories(WebElement categories) {
        this.categories = categories;
    }
}