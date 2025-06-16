package com.royce.blood_donation.services;

import com.royce.blood_donation.models.BloodCapacity;
import com.royce.blood_donation.models.BloodType;
import com.royce.blood_donation.responses.BloodCapacityResponse;
import com.royce.blood_donation.responses.BloodTypeResponse;

import java.util.List;

public interface IBloodService {
    public List<BloodTypeResponse> getAllBloodTypes();
    public BloodType getBloodTypeById(int id);
    public BloodCapacity getBloodCapacityById(int id);
    public List<BloodCapacityResponse> getAllBloodCapacity();
}
