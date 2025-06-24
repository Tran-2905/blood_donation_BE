package com.royce.blood_donation.services;

import com.royce.blood_donation.models.BloodCapacity;
import com.royce.blood_donation.models.BloodComponents;
import com.royce.blood_donation.models.BloodType;
import com.royce.blood_donation.models.enums.BloodComponent;
import com.royce.blood_donation.responses.BloodCapacityResponse;
import com.royce.blood_donation.responses.BloodTypeResponse;

import java.util.List;

public interface IBloodService {
    public List<BloodTypeResponse> getAllBloodTypes();
    public BloodType getBloodTypeById(int id);
    public BloodCapacity getBloodCapacityById(int id);
    public BloodCapacityResponse getAllBloodCapacityByBloodTypeAndBloodComponent(int idBloodType, int idBloodComponent);
    public List<BloodType> getBloodTypes();
    public BloodComponents getBloodComponentById(int id);
    public List<BloodComponents> getBloodComponents();
}
