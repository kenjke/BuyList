package com.griddynamics.buylist.util;

import org.assertj.core.api.Assertions;
import ru.yandex.qatools.allure.annotations.Step;

public class BaseAssertions {

    @Step("{2}")
    public void checkEqual(String actual, String expected, String message) {
        AllureUtils.saveTextLog("Actual", actual);
        AllureUtils.saveTextLog("Expected", expected);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}