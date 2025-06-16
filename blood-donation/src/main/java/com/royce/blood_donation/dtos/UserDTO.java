package com.royce.blood_donation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.royce.blood_donation.models.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Date;


@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;


    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("password_hash")
    private String password;

    @Enumerated(EnumType.STRING)
    @JsonProperty("role")
    private Role role;

    @JsonProperty("address")
    private String address;

    @JsonProperty("country")
    private String country;

    @JsonProperty("city")
    private String city;

    @JsonProperty("blood_type_id")
    private int bloodType;

    @JsonProperty("facebook_account_id")
    private String facebookAccountId;

    @JsonProperty("google_account_id")
    private String googleAccountId;

    @JsonProperty("date_of_birth")
    private Date dateOfBirth;
}
