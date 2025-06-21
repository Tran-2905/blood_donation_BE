package com.royce.blood_donation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @JsonProperty("email")
    @NotBlank(message = "email can not be null")
    private String email;

    @JsonProperty("password_hash")
    @NotBlank(message = "password can not be null")
    private String password;

    @JsonProperty("facebook_account")
    private String facebookAccount;

    @JsonProperty("google_account")
    private String googleAccount;
}
