package com.royce.blood_donation.repositories;

import com.royce.blood_donation.models.blood.BloodCapacity;
import com.royce.blood_donation.models.blood.BloodCapacityId;
import com.royce.blood_donation.models.blood.BloodComponents;
import com.royce.blood_donation.models.blood.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBloodCapacityRepository extends JpaRepository<BloodCapacity, Integer> {
    BloodCapacity findBloodCapacityById(BloodCapacityId id);
    List<BloodCapacity> findAllByDonorBloodTypeIdAndComponentIdAndCanDonate(BloodType donorBloodTypeId, BloodComponents componentId, boolean canDonate);

    List<BloodCapacity> findAllByDonorBloodTypeIdAndComponentIdAndCanReceive(BloodType donorBloodTypeId, BloodComponents componentId, boolean canReceive);

    BloodCapacity findBloodCapacityByDonorBloodTypeId_IdAndComponentId_Id(int donorBloodTypeIdId, int componentIdId);
}
