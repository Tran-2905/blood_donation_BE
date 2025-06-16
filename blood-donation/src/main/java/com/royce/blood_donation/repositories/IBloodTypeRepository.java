package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBloodTypeRepository extends JpaRepository<BloodType, Integer> {
    public BloodType findById(int id);
}
