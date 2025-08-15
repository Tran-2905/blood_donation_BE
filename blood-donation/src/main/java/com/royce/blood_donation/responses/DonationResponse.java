package com.royce.blood_donation.responses;

import com.royce.blood_donation.models.enums.Progress;
import com.royce.blood_donation.models.enums.RequestType;
import com.royce.blood_donation.models.enums.StatusDonation;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DonationResponse {
    private int donationId;
    private Long donorUserId;               // chỉ lưu id thay vì đối tượng User
    private Long recipientUserId;           // chỉ lưu id thay vì đối tượng User
    private RequestType requestType;
    private int requestId;

    private String bloodType;        // DTO con cho BloodType
    private String component;  // DTO con cho BloodComponents

    private Integer unitsDonated;
    private Date donationDate;
    private StatusDonation status;
    private Progress progress;
    private String notes;
}
