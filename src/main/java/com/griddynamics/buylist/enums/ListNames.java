package com.griddynamics.buylist.enums;

public enum ListNames {

    Apples("apples"), Bottles("bottles"), Wishes("Wishes"), ForDinner("for dinner");

    String displayedName;

    ListNames(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}
