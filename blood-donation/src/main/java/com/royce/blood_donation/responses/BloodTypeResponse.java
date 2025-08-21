package com.royce.blood_donation.responses;

import com.royce.blood_donation.models.blood.BloodType;
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
    private String description;
    private String percent;
    private String fact;
    public static BloodTypeResponse getBloodTypeResponse(BloodType bloodType) {
        if(bloodType.getRh().equals(RhType.Positive)){
            return BloodTypeResponse.builder()
                    .bloodType(bloodType.getType()+"+")
                    .bloodTypeId(bloodType.getId())
                    .description(bloodType.getDescription())
                    .percent(bloodType.getPercent())
                    .fact(bloodType.getFact())
                    .build();
        }else if (bloodType.getRh().equals(RhType.Negative)){
            return BloodTypeResponse.builder()
                    .bloodType(bloodType.getType()+"-")
                    .bloodTypeId(bloodType.getId())
                    .description(bloodType.getDescription())
                    .percent(bloodType.getPercent())
                    .fact(bloodType.getFact())
                    .build();
        }
            return BloodTypeResponse.builder()
                    .bloodType(bloodType.getType())
                    .bloodTypeId(bloodType.getId())
                    .description(bloodType.getDescription())
                    .percent(bloodType.getPercent())
                    .fact(bloodType.getFact())
                    .build();
    }
}
