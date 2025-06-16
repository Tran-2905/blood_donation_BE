package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.BloodComponents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBloodComponentRepository extends JpaRepository<BloodComponents, Integer> {
}
