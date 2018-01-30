package com.griddynamics.buylist.enums;

public enum EnterNames {

    List("list"), Category("category");

    String displayedName;

    EnterNames(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}