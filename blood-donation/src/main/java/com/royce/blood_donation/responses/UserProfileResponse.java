package com.royce.blood_donation.responses;

import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserProfileResponse {
    private String fullName;
    private String email;
    private String bloodType;
    private Date lastDonation;
    private Date memberSince;
    private String phoneNumber;
    private Date dateOfBirth;
    private String address;
    private String condition;
    private String medication;
    public UserProfileResponse(String fullName, String email, String bloodType, Date lastDonation, Date memberSince, String phoneNumber, Date dateOfBirth, String address, String condition, String medication) {
        this.fullName = fullName;
        this.email = email;
        this.bloodType = bloodType;
        this.lastDonation = lastDonation;
        this.memberSince = memberSince;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }
}
