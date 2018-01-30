package com.griddynamics.buylist.enums;

public enum Measures {

    Bottles("bottles"), Kilogramms(".kg");

    String displayedName;

    Measures(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}