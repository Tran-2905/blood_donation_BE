package com.royce.blood_donation.Response;

import com.royce.blood_donation.Model.BloodCapacity;
import com.royce.blood_donation.Model.BloodType;
import com.royce.blood_donation.Model.enums.RhType;
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
    private String bloodTypeName;
    private List<String> donorBloodTypeName;
    private List<String> receivingBloodTypeName;

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
