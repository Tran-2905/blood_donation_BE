package com.royce.blood_donation.Service;

import com.royce.blood_donation.Model.BloodCapacity;
import com.royce.blood_donation.Model.BloodType;
import com.royce.blood_donation.Repository.IBloodCapacityRepository;
import com.royce.blood_donation.Repository.IBloodComponentRepository;
import com.royce.blood_donation.Repository.IBloodTypeRepository;
import com.royce.blood_donation.Response.BloodCapacityResponse;
import com.royce.blood_donation.Response.BloodTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.royce.blood_donation.Response.BloodCapacityResponse.*;

@Service
@RequiredArgsConstructor
public class BloodService implements IBloodService {
    private final IBloodCapacityRepository capacityRepository;
    private final IBloodTypeRepository typeRepository;
    private final IBloodComponentRepository componentRepository;

    @Override
    public List<BloodTypeResponse> getAllBloodTypes() {
        return typeRepository.findAll().stream().map(BloodTypeResponse::getBloodTypeResponse).toList();
    }

    @Override
    public BloodType getBloodTypeById(int id) {
        return typeRepository.findById(id).orElse(null);
    }

    @Override
    public BloodCapacity getBloodCapacityById(int id) {
        return capacityRepository.findById(id).orElse(null);
    }

    @Override
    public List<BloodCapacityResponse> getAllBloodCapacity() {
        List<BloodType> bloodTypes = typeRepository.findAll();
        List<BloodCapacityResponse> bloodCapacityResponses = new ArrayList<>();
        for (BloodType bloodType : bloodTypes) {
            BloodCapacityResponse bloodCapacityResponse = new BloodCapacityResponse();
            List<BloodCapacity> bloodCapacityDonates = capacityRepository.findAllByDonorBloodTypeIdAndComponentIdAndCanDonate(bloodType, componentRepository.getReferenceById(1), true);
            List<BloodCapacity> bloodCapacityReceives = capacityRepository.findAllByDonorBloodTypeIdAndComponentIdAndCanReceive(bloodType,componentRepository.getReferenceById(1), true);
            bloodCapacityResponse.setBloodTypeName(getBloodTypeName(bloodType) );
            bloodCapacityResponse.setDonorBloodTypeName(getListBloodType(bloodCapacityDonates));
            bloodCapacityResponse.setReceivingBloodTypeName(getListBloodType(bloodCapacityReceives));
            bloodCapacityResponses.add(bloodCapacityResponse);
        }
        return bloodCapacityResponses;
    }

}
