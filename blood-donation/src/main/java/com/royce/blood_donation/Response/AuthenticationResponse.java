package com.royce.blood_donation.Response;

import com.royce.blood_donation.Model.User;
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
