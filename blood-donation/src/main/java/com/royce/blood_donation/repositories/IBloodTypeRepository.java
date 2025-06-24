package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.blood.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBloodTypeRepository extends JpaRepository<BloodType, Integer> {
    public BloodType findById(int id);
}
