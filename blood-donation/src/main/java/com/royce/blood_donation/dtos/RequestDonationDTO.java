package com.royce.blood_donation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.royce.blood_donation.models.User;
import com.royce.blood_donation.models.enums.Gender;
import com.royce.blood_donation.models.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDonationDTO {

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @JsonProperty("gender")
    private Gender gender;

    @JsonProperty("blood_type_id")
    private int bloodTypeId;

    private float weight;

    private float height;

    @JsonProperty("last_donation")
    private Date lastDonation;

    @JsonProperty("available_date")
    private Date availableDate;

    @JsonProperty("available_time")
    private String availableTime;

    private String notes;

    @JsonProperty("accept_general_term")
    private boolean acceptGeneralTerm;

    @JsonProperty("accept_contact_term")
    private boolean acceptContactTerm;
}
