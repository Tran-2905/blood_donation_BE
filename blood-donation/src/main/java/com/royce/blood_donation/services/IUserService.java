package com.royce.blood_donation.services;

import com.royce.blood_donation.dtos.UserLoginDTO;
import com.royce.blood_donation.dtos.RefreshToken;
import com.royce.blood_donation.dtos.UserDTO;
import com.royce.blood_donation.models.User;
import com.royce.blood_donation.responses.AuthenticationResponse;

public interface IUserService {
    void createUser(UserDTO userDTO);

    AuthenticationResponse login(UserLoginDTO userLoginDTO);

    User getUserByPhoneNumber(String phoneNumber);

    public AuthenticationResponse refreshToken(RefreshToken refreshToken);
}
