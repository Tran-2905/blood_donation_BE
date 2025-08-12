package com.royce.blood_donation.services.auth;

import com.royce.blood_donation.dtos.UserLoginDTO;
import com.royce.blood_donation.dtos.RefreshToken;
import com.royce.blood_donation.dtos.UserDTO;
import com.royce.blood_donation.responses.AuthenticationResponse;

public interface IAuthService {
    void createUser(UserDTO userDTO);

    AuthenticationResponse login(UserLoginDTO userLoginDTO);

    public AuthenticationResponse refreshToken(RefreshToken refreshToken);
}
