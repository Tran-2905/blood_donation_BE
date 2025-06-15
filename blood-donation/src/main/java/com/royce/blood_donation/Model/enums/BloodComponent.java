package com.royce.blood_donation.Model.enums;


public enum BloodComponent {
    WHOLE_BLOOD("Whole Blood"),
    RED_BLOOD_CELLS("Red Blood Cells"),
    PLASMA("Plasma"),
    PLATELET("Platelet");
    private final String displayName;
    BloodComponent(String displayName) {
        this.displayName = displayName;
    }
    @Override
    public String toString() {
        return displayName;
    }
}
