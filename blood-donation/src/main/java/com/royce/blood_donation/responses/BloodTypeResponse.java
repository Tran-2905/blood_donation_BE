package com.royce.blood_donation.responses;

import com.royce.blood_donation.models.BloodType;
import com.royce.blood_donation.models.enums.RhType;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodTypeResponse {
    private int bloodTypeId;
    private String bloodType;
    public static BloodTypeResponse getBloodTypeResponse(BloodType bloodType) {
        if(bloodType.getRh().equals(RhType.Positive)){
            return BloodTypeResponse.builder()
                    .bloodType(bloodType.getType()+"+")
                    .bloodTypeId(bloodType.getId())
                    .build();
        }else if (bloodType.getRh().equals(RhType.Negative)){
            return BloodTypeResponse.builder()
                    .bloodType(bloodType.getType()+"-")
                    .bloodTypeId(bloodType.getId())
                    .build();
        }
            return BloodTypeResponse.builder()
                    .bloodType(bloodType.getType())
                    .bloodTypeId(bloodType.getId())
                    .build();
    }
}
