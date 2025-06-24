package com.royce.blood_donation.services.user;

import com.royce.blood_donation.dtos.UserLoginDTO;
import com.royce.blood_donation.dtos.RefreshToken;
import com.royce.blood_donation.dtos.UserDTO;
import com.royce.blood_donation.responses.AuthenticationResponse;

public interface IUserService {
    void createUser(UserDTO userDTO);

    AuthenticationResponse login(UserLoginDTO userLoginDTO);

    public AuthenticationResponse refreshToken(RefreshToken refreshToken);
}
