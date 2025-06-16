package com.royce.blood_donation.Service;

import com.royce.blood_donation.Model.BloodCapacity;
import com.royce.blood_donation.Model.BloodType;
import com.royce.blood_donation.Response.BloodCapacityResponse;
import com.royce.blood_donation.Response.BloodTypeResponse;

import java.util.List;

public interface IBloodService {
    public List<BloodTypeResponse> getAllBloodTypes();
    public BloodType getBloodTypeById(int id);
    public BloodCapacity getBloodCapacityById(int id);
    public List<BloodCapacityResponse> getAllBloodCapacity();
}
