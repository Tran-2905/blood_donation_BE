package com.royce.blood_donation.responses;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
//    private String code;
    private String token;
    private String refreshToken;
}
