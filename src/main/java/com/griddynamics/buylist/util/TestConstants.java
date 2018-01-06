package com.griddynamics.buylist.util;

import org.openqa.selenium.Point;

import java.util.Arrays;
import java.util.List;

public interface TestConstants {

    List<String> LIST_NAMES = Arrays.asList("apples", "bottles", "wishes", "for dinner");
    List<String> ENTER_NAME = Arrays.asList("list", "category");
    String TOPIC_NAME_STEP = "Get topic name and check that it's equal to ";
    String PRODUCT_NAME = "milk";
    String PRICE = "2";
    String AMOUNT = "3";
    List<String> MEASURES_LIST = Arrays.asList("bottles", ".kg");
    List<String> CATEGORY_LIST = Arrays.asList("Pet products", "Fencing");
    String TOTAL_STEP = "Get total and check that it's equal to ";
    List<String> SIZES = Arrays.asList("0", "1", "2");
    String SIZE_STEP = "Get size of found elements and check that it's equal to ";
    List<String> SORT_LIST = Arrays.asList("By category", "By alphabet");
    Point SORT_LIST_POINT = new Point(0, 65);
    String LINEAR_LAYOUT_WIDGET = "android.widget.LinearLayout";
    List<String> CURRENCY_LIST = Arrays.asList("£", "$");
    Point CURRENCY_POINT = new Point(0, 234);
    String CATEGORIES_LIST_TEXT_VIEW = "Categories List";
    Point CATEGORIES_LIST_POINT = new Point(0, 1457);
    Point PRICE_POINT = new Point(954, 1334);
    String CHECKBOX_WIDGET = "android.widget.CheckBox";
    String TRUE_VALUE = "true";
    String FALSE_VALUE = "false";
    String CHECKED_OPTION_STEP = "Check that option is checked";
    String UNCHECKED_OPTION_STEP = "Check that option is unchecked";
    String DEFAULT_LIST = "My List";
    List<String> SPINNER_NAMES = Arrays.asList("measure", "category", "sort list", "currency");
}