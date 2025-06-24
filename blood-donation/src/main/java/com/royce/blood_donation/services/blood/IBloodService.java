package com.royce.blood_donation.services.blood;

import com.royce.blood_donation.models.blood.BloodCapacity;
import com.royce.blood_donation.models.blood.BloodComponents;
import com.royce.blood_donation.models.blood.BloodType;
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
