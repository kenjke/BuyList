package com.griddynamics.buylist.enums;

public enum Currencies {

    Funt("£"), Dollar("$");

    String displayedName;

    Currencies(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}