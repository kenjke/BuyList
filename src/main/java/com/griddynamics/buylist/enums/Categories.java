package com.griddynamics.buylist.enums;

public enum Categories {

    PetProducts("Pet products"), Fencing("Fencing");

    String displayedName;

    Categories(String displayedName) {
        this.displayedName = displayedName;
    }

    @Override
    public String toString() {
        return displayedName;
    }
}