package com.solvd.carina.saucedemo.gui.enums;

public enum SortType {

    PRICE_LOW_TO_HIGH("lohi"),
    PRICE_HIGH_TO_LOW("hilo"),
    NAME_A_TO_Z("az"),
    NAME_Z_TO_A("za");

    SortType(String value) {
        this.value = value;
    }

    final String value;

    public String getValue() {
        return value;
    }
}
