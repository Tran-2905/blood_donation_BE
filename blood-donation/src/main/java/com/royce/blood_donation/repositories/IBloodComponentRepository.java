package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.blood.BloodComponents;
import com.royce.blood_donation.models.enums.BloodComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBloodComponentRepository extends JpaRepository<BloodComponents, Integer> {
    BloodComponents findById(int id);
    BloodComponents findBloodComponentsByComponentName(BloodComponent componentName);
}
