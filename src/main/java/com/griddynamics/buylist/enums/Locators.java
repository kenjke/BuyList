package com.griddynamics.buylist.enums;


public enum Locators {

    LinearLayoutClass("android.widget.LinearLayout"), CheckedTextViewXpath("//android.widget.CheckedTextView[@text='%s']"),
    EditTextClass("android.widget.EditText"), ButtonPanelId("android:id/buttonPanel"), Button1Id("android:id/button1"),
    Rr1Id("com.slava.buylist:id/rr1"), ImageView1Id("com.slava.buylist:id/imageView1"), Scroll("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"))"),
    HierarchyXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[%s]"),
    PriceCheckBoxXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.CheckBox"),
    TextUiAutomator("text(\"%s\")");

    String displayedName;

    Locators(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}