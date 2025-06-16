package com.royce.blood_donation.Converter;

import com.royce.blood_donation.Model.enums.BloodComponent;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BloodComponentConverter implements AttributeConverter<BloodComponent, String> {
    @Override
    public String convertToDatabaseColumn(BloodComponent attribute) {
        return (attribute != null) ? attribute.toString() : null;
    }

    @Override
    public BloodComponent convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        for (BloodComponent bc : BloodComponent.values()) {
            if (bc.toString().equalsIgnoreCase(dbData)) {
                return bc;
            }
        }
        throw new IllegalArgumentException("Unknown blood component: " + dbData);
    }
}
