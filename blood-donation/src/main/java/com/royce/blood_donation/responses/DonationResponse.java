package com.royce.blood_donation.responses;

import com.royce.blood_donation.models.donation.Donation;
import com.royce.blood_donation.models.enums.Progress;
import com.royce.blood_donation.models.enums.RequestType;
import com.royce.blood_donation.models.enums.StatusDonation;
import lombok.*;

import java.util.Date;

@Data
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

    public DonationResponse(Donation donation) {
        this.donationId = donation.getDonationId();
        this.donorUserId = donation.getDonorUserId() != null ? donation.getDonorUserId().getId() : null;
        this.recipientUserId = donation.getRecipientUserId() != null ? donation.getRecipientUserId().getId() : null;
        this.requestType = donation.getRequestType();
        this.requestId = donation.getRequestId();
        this.bloodType = donation.getBloodTypeId().getType() + donation.getBloodTypeId().getRh().name();
        this.component = donation.getComponentId().getComponentName().name();
        this.unitsDonated = donation.getUnitsDonated();
        this.donationDate = donation.getDonationDate();
        this.status = donation.getStatus();
        this.progress = donation.getProgress();
        this.notes = donation.getNotes();
    }
}
