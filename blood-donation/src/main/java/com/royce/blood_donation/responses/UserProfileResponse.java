package com.royce.blood_donation.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@Data
@Getter
@Setter
@NoArgsConstructor
public class UserProfileResponse {
    private String fullName;
    private String email;
    private String bloodType;
    private Date lastDonation;
    private LocalDateTime memberSince;
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private String address;
    private String condition;
    private String medication;
    public UserProfileResponse(String fullName, String email, String bloodType, Date lastDonation, LocalDateTime memberSince, String phoneNumber, Date dateOfBirth, String address) {
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
