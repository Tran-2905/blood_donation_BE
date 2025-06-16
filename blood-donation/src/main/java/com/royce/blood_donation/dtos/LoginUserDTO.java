package com.royce.blood_donation.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDTO {
    @JsonProperty("phone_number")
    @NotBlank(message = "Phone number can not be null")
    private String phoneNumber;
    @JsonProperty("password_hash")
    @NotBlank(message = "password can not be null")
    private String password;
}
