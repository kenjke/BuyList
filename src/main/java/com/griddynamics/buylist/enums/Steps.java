package com.griddynamics.buylist.enums;

public enum Steps {

    TopicName("Get topic name and check that it's equal to "), Total("Get total and check that it's equal to "),
    Size("Get size of found elements and check that it's equal to "), Checked("Check that option is checked"),
    Unchecked("Check that option is unchecked");

    String displayedName;

    Steps(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}