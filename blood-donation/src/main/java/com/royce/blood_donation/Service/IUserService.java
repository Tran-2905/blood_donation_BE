package com.royce.blood_donation.Service;

import com.royce.blood_donation.DTO.LoginUserDTO;
import com.royce.blood_donation.DTO.RefreshToken;
import com.royce.blood_donation.DTO.UserDTO;
import com.royce.blood_donation.Model.User;
import com.royce.blood_donation.Response.AuthenticationResponse;

public interface IUserService{
    User createUser(UserDTO userDTO);
    AuthenticationResponse login(LoginUserDTO loginUserDTO);
    User getUserByPhoneNumber(String phoneNumber);
    public AuthenticationResponse refreshToken(RefreshToken refreshToken);
}
