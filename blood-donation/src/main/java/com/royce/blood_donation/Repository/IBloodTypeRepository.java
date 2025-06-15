package com.royce.blood_donation.Repository;

import com.royce.blood_donation.Model.BloodCapacity;
import com.royce.blood_donation.Model.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBloodTypeRepository extends JpaRepository<BloodType, Integer> {

}
