package com.royce.blood_donation.responses;

import com.royce.blood_donation.models.BloodCapacity;
import com.royce.blood_donation.models.BloodType;
import com.royce.blood_donation.models.enums.RhType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodCapacityResponse {
    private String type;
    private List<String> canDonateTo;
    private List<String> canReceiveFrom;

    public static List<String> getListBloodType(List<BloodCapacity> bloodCapacities) {
        List<String> donorBloodTypeName = new ArrayList<>();
        for (BloodCapacity bloodCapacity : bloodCapacities) {
            donorBloodTypeName.add(getBloodTypeName(bloodCapacity));
        }
        return donorBloodTypeName;
    }

    public static String getBloodTypeName(BloodCapacity bloodCapacity) {
        String bloodTypeName = null;
        if(bloodCapacity.getRecipientBloodTypeId().getRh().equals(RhType.Positive)){
            bloodTypeName = bloodCapacity.getRecipientBloodTypeId().getType() + "+";
        }
        else{
            bloodTypeName = bloodCapacity.getRecipientBloodTypeId().getType() + "-";
        }
        return bloodTypeName;
    }

    public static String getBloodTypeName(BloodType bloodType) {
        if(bloodType.getRh().equals(RhType.Positive)){
            return bloodType.getType() + "+";
        }else {
            return bloodType.getType() + "-";
        }
    }


}
