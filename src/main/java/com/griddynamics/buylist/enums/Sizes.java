package com.griddynamics.buylist.enums;

public enum Sizes {

    Zero("0"), One("1"), Two("2");

    String displayedName;

    Sizes(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}