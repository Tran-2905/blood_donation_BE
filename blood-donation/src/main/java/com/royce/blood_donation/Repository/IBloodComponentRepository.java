package com.royce.blood_donation.Repository;

import com.royce.blood_donation.Model.BloodComponents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBloodComponentRepository extends JpaRepository<BloodComponents, Integer> {
}
