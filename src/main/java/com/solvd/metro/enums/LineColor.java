package com.solvd.metro.enums;

public enum LineColor {

    RED("Red", "#FF0000"),
    BLUE("Blue", "#0000FF"),
    GREEN("Green", "#00FF00"),
    YELLOW("Yellow", "#FFFF00");

    private final String colorName;
    private final String hexCode;

    static {
        System.out.println("LineColor enum loaded");
    }

    LineColor(String colorName, String hexCode) {
        this.colorName = colorName;
        this.hexCode = hexCode;
    }

    public String getDisplayName() {
        return colorName + " (" + hexCode + ")";
    }
}