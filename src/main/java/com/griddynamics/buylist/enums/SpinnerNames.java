package com.griddynamics.buylist.enums;

public enum SpinnerNames {

    Measure("measure"), Category("category"), SortList("sort list"), Currency("currency");

    String displayedName;

    SpinnerNames(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}