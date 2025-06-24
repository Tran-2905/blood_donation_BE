package com.royce.blood_donation.services.blood;

import com.royce.blood_donation.models.blood.BloodCapacity;
import com.royce.blood_donation.models.blood.BloodComponents;
import com.royce.blood_donation.models.blood.BloodType;
import com.royce.blood_donation.repositories.IBloodCapacityRepository;
import com.royce.blood_donation.repositories.IBloodComponentRepository;
import com.royce.blood_donation.repositories.IBloodTypeRepository;
import com.royce.blood_donation.responses.BloodCapacityResponse;
import com.royce.blood_donation.responses.BloodTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.royce.blood_donation.responses.BloodCapacityResponse.*;

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
        return typeRepository.findById(id);
    }

    @Override
    public BloodCapacity getBloodCapacityById(int id) {
        return capacityRepository.findById(id).orElse(null);
    }

    @Override
    public BloodCapacityResponse getAllBloodCapacityByBloodTypeAndBloodComponent(int idBloodType, int idBloodComponent) {
        BloodType bloodType = typeRepository.findById(idBloodType);
        BloodCapacityResponse bloodCapacityResponses = null;
            BloodCapacityResponse bloodCapacityResponse = new BloodCapacityResponse();
            List<BloodCapacity> bloodCapacityDonates = capacityRepository.findAllByDonorBloodTypeIdAndComponentIdAndCanDonate(bloodType, componentRepository.findById(idBloodComponent), true);
            List<BloodCapacity> bloodCapacityReceives = capacityRepository.findAllByDonorBloodTypeIdAndComponentIdAndCanReceive(bloodType,componentRepository.findById(idBloodComponent), true);
            bloodCapacityResponse.setType(getBloodTypeName(bloodType) );
            bloodCapacityResponse.setCanDonateTo(getListBloodType(bloodCapacityDonates));
            bloodCapacityResponse.setCanReceiveFrom(getListBloodType(bloodCapacityReceives));
        return bloodCapacityResponse;
    }
    @Override
    public List<BloodComponents> getBloodComponents(){
        return componentRepository.findAll();
    }

    @Override
    public List<BloodType> getBloodTypes(){
        return typeRepository.findAll();
    }

    @Override
    public BloodComponents getBloodComponentById(int id){
        return componentRepository.findById(id);
    }
}