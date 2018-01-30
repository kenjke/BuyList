package com.griddynamics.buylist.enums;

public enum SortList {

    ByCategory("By category"), ByAlphabet("By alphabet");

    String displayedName;

    SortList(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}